from math import *
from data import *
from vector_math import *

def sphere_intersection_point(ray, sphere):
   a = dot_vector(ray.dir, ray.dir)
   b = dot_vector(difference_point(ray.pt, sphere.center), ray.dir)*2
   c = (dot_vector(difference_point(ray.pt, sphere.center),
        difference_point(ray.pt, sphere.center)) - (sphere.radius)**2)
   d = b**2 - 4*a*c
   if d < 0:
      return None
   t1 = (-b + sqrt(d))/(2*a) 
   t2 = (-b - sqrt(d))/(2*a)
   point1 = translate_point(ray.pt, scale_vector(ray.dir, t1))
   point2 = translate_point(ray.pt, scale_vector(ray.dir, t2))
   if t1 < 0 and t2 < 0:
      return None
   if t1 >= 0 and t2 >= 0:
      if t1 > t2:
         return point2   
      else:
         return point1
   elif t1 >= 0:
      return point1
   else:
      return point2
      
def find_intersection_points(sphere_list, ray):
   l = []
   for s in sphere_list:
     p = sphere_intersection_point(ray, s)
     if p != None:
        l.append((s, p))
   return l

def sphere_normal_at_point(sphere, point):
   return normalize_vector(vector_from_to(sphere.center, point))
