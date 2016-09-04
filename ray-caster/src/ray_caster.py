from data import *
from cast import *
from commandline import *
from sys import *

if len(argv) < 2:
   print "Error, 2 arguments required"
   exit()

def main():
   sphere_list = []
   try:
      input = open(argv[1], 'r')
      for l in input:
         try:
	 values = [float(x) for x in l.split()]
            if len(values) == 11:
               x = values[0]
               y = values[1]
               z = values[2]
               radius = values[3]
               r = values[4]
               g = values[5]
               b = values[6]
               ambient = values[7]
               diffuse = values[8]
               specular = values[9]
               roughness = values[10]
               sphere_list.append(Sphere(Point(x, y, z), radius, Color(r, g, b), Finish(ambient, diffuse, specular, roughness)))
            else:
               print "Bad Sphere"
         except:
            print "Bad Sphere"
   except:
      print "usage: python ray_caster.py <filename> [-eye x y z] [-view min_x max_x min_y max_y width height] [-light x y z r g b] [-ambient r g b]"
      exit()

   view = get_view(argv)
   cast_all_rays(view[0], view[1], view[2], view[3], view[4], view[5], get_eye(argv), sphere_list, get_ambient(argv), get_light(argv))


   #eye_point = Point(0.0, 0.0, -14.0)
   #cast_all_rays(-10, 10, -7.5, 7.5, 1024, 768, eye_point, sphere_list, Color(1.0, 1.0, 1.0), Light(Point(-100.0, 100.0, -100.0), Color(1.5, 1.5, 1.5)))


  

if __name__ == "__main__":
   main()
