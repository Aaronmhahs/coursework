from collisions import *
from vector_math import *
from data import *

def cast_ray(ray, sphere_list, color, light, point):
   tups = find_intersection_points(sphere_list, ray)
   if tups != []:
      nearest = tups[0][0]
      nearest_point = tups[0][1]
      nearest_dist = length_vector(difference_point(tups[0][1], ray.pt))
      for (s, p) in tups:
         dist = length_vector(difference_point(p, ray.pt))
         if dist < nearest_dist:
            nearest = s
            nearest_point = p
            nearest_dist = dist

      n = sphere_normal_at_point(nearest, nearest_point)
      Pe = translate_point(nearest_point, scale_vector(n, .01))
      Ldir = normalize_vector(difference_point(light.pt, Pe))
      dot = dot_vector(n, Ldir)
      Vdir = normalize_vector(difference_point(Pe, point))
      r = ref(Ldir, dot, n)
      i = dot_vector(r, Vdir)

      ambient = add_ambient(scale_color(nearest.color, nearest.finish.ambient), color)
      diffuse = add_diffuse(dot, light.color, nearest.color, nearest.finish.diffuse)
      specular = add_specular(light.color, nearest.finish.specular, i, nearest.finish.roughness)

      if dot > 0 and find_intersection_points(sphere_list, Ray(Pe, Ldir)) == [] and i > 0:
         return add_colors(ambient, diffuse, specular)
      elif dot > 0 and find_intersection_points(sphere_list, Ray(Pe, Ldir)) == [] and i <= 0:
         return add_colors(ambient, diffuse)
      else:
         return ambient
   return Color(1.0, 1.0, 1.0)

def cast_all_rays(min_x, max_x, min_y, max_y, width, height, eye_point, sphere_list, color, light):
   output = open('image.ppm', 'w')
   print >> output, "P3"
   print >> output, width, height
   print >> output, "255"
   dx = (max_x - min_x)/float(width)
   dy = (max_y - min_y)/float(height)
   for h in range(height):
      for w in range(width):
         p = Point(min_x + dx*w, max_y - dy*h, 0)
         ray = Ray(eye_point, difference_point(p, eye_point))
         c = cast_ray(ray, sphere_list, color, light, eye_point)
         print_colors(c, output)

def print_colors(c, output):
   r = int(c.r*255)
   g = int(c.g*255)
   b = int(c.b*255)
   if r > 255:
      r = 255
   if g > 255:
      g = 255
   if b > 255:
      b = 255
   print >> output, r, g, b
   
def scale_color(c, scalar):
   return Color(c.r * scalar, c.g * scalar, c.b * scalar)

def add_ambient(c1, c2):
   return Color(c1.r * c2.r, c1.g * c2.g, c1.b * c2.b)

def add_diffuse(dot, clight, csphere, diffuse):
   return Color(clight.r * csphere.r * dot * diffuse, clight.g * csphere.g * dot * diffuse, clight.b * csphere.b * dot * diffuse)

def add_specular(c, spec, intensity, rough):
   v = spec*intensity**(1.0/rough)
   return Color(c.r * v, c.g * v, c.b * v)

def add_colors(c1, c2, c3 = None):
   if c3 != None:
      return Color(c1.r + c2.r + c3.r, c1.g + c2.g + c3.g, c1.b + c2.b + c3.b)
   return Color(c1.r + c2.r, c1.g + c2.g, c1.b + c2.b)

def ref(ldir, dot, norm):
   z = Vector(norm.x * (2*dot), norm.y * (2*dot), norm.z * (2*dot)) 
   return Vector(ldir.x - z.x, ldir.y - z.y, ldir.z - z.z)

def dist(p1, p2):
   return length_vector(difference_point(p1, p2))
