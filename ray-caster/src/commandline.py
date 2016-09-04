from sys import *
from data import *

def get_eye(argv):
   eye_point = Point(0.0, 0.0, -14.0)
   if '-eye' in argv:
      i = argv.index('-eye')
      eye_point = Point(float(argv[i+1]), float(argv[i+2]), float(argv[i+3]))
   return eye_point

def get_view(argv):
   min_x = -10
   max_x = 10
   min_y = -7.5
   max_y = 7.5
   width = 1024
   height = 768
   if '-view' in argv:
      i = argv.index('-view')
      min_x = argv[i+1]
      max_x = argv[i+2]
      min_y = argv[i+3]
      max_y = argv[i+4]
      width = argv[i+5]
      height = argv[i+6]
   return float(min_x), float(max_x), float(min_y), float(max_y), int(width), int(height)

def get_light(argv):
   light = Light(Point(-100.0, 100.0, -100.0), Color(1.5, 1.5, 1.5))
   if '-light' in argv:
      i = argv.index('-light')
      light = Light(Point(float(argv[i+1]), float(argv[i+2]), float(argv[i+3])), Color(float(argv[i+4]), float(argv[i+5]), float(argv[i+6])))
   return light

def get_ambient(argv):
   ambient = Color(1.0, 1.0, 1.0)
   if '-ambient' in argv:
      i = argv.index('-ambient')
      ambient = Color(float(argv[i+1]), float(argv[i+2]), float(argv[i+3]))
   return ambient
