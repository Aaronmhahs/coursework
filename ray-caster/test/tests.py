import unittest
from cast import *
from data import * 

class TestData(unittest.TestCase):

   def test_cast_ray(self):
      r = Ray(Point(-1.0, 2.0, 0.0), Vector(10.0, 0.0, 0.0))
      s1 = Sphere(Point(2.0, 2.0, 0.0), 1.0, Color(0.0, 0.0, 1.0), Finish(0.2, 0.4, 0.5, 0.05))
      s2 = Sphere(Point(4.0, 2.0, 0.0), 0.5, Color(1.0, 0.0, 0.0), Finish(0.4, 0.4, 0.5, 0.05))
      l = [s1, s2]
      color = Color(1.0, 1.0, 1.0)
      light = Light(Point(5.0, 2.0, 0.0), Color(1.5, 1.5, 1.5))
      point = Point(-1.0, 2.0, 0.0)
      self.assertEqual(cast_ray(r, l, color, light, point), Color(0.0, 0.0, 0.2))
   
   def test_cast_ray2(self):
      r = Ray(Point(5.0, 2.0, 0.0), Vector(-10.0, 0.0, 0.0))
      s1 = Sphere(Point(2.0, 2.0, 0.0), 1.0, Color(0.0, 0.0, 1.0), Finish(0.2, 0.4, 0.5, 0.05))
      s2 = Sphere(Point(4.0, 2.0, 0.0), 0.5, Color(1.0, 0.0, 0.0), Finish(0.4, 0.4, 0.5, 0.05))
      l = [s1, s2]
      color = Color(1.0, 1.0, 1.0)
      light = Light(Point(-1.0, 2.0, 0.0), Color(1.5, 1.5, 1.5))
      point = Point(5.0, 2.0, 0.0)
      self.assertEqual(cast_ray(r, l, color, light, point), Color(0.4, 0.0, 0.0))
   
   def test_scale_color(self):
      c = Color(1.0, 1.0, 1.0)
      f = 3.0
      self.assertEqual(scale_color(c, f), Color(3.0, 3.0, 3.0))
   
   def test_scale_color2(self):
      c = Color(1.0, 2.0, -1.0)
      f = 3.0
      self.assertEqual(scale_color(c, f), Color(3.0, 6.0, -3.0))

   def test_add_ambient(self):
      c1 = Color(1.0, 1.0, 1.0)
      c2 = Color(1.0, 2.0, 3.0)
      self.assertEqual(add_ambient(c1, c2), Color(1.0, 2.0, 3.0))

   def test_add_ambient2(self):
      c1 = Color(1.0, -1.0, 0.0)
      c2 = Color(1.0, 2.0, 3.0)
      self.assertEqual(add_ambient(c1, c2), Color(1.0, -2.0, 0.0))

   def test_add_diffuse(self):
      dot = 2.0
      cl = Color(1.0, 1.0, 1.0)
      cs = Color(1.0, 2.0, 3.0)
      diff = 2.0
      self.assertEqual(add_diffuse(dot, cl, cs, diff), Color(4.0, 8.0, 12.0))
 
   def test_add_diffuse2(self):
      dot = 1.0
      cl = Color(1.0, 1.0, 1.0)
      cs = Color(1.0, -2.0, 0.0)
      diff = 1.5
      self.assertEqual(add_diffuse(dot, cl, cs, diff), Color(1.5, -3.0, 0.0))

   def test_add_specular(self):
      c = Color(1.0, 2.0, 3.0)
      s = 3.0
      i = 2.0
      r = 1.0
      self.assertEqual(add_specular(c, s, i, r), Color(6.0, 12.0, 18.0))
   
   def test_add_specular2(self):
      c = Color(-1.0, 2.0, 0.0)
      s = 1.0
      i = 2.0
      r = -1.0
      self.assertEqual(add_specular(c, s, i, r), Color(-0.5, 1.0, 0.0))

   def test_add_colors(self):
      c1 = Color(1.0, 1.0, 1.0)
      c2 = Color(1.0, 2.0, 3.0)
      c3 = Color(1.5, 2.5, 3.5)
      self.assertEqual(add_colors(c1, c2, c3), Color(3.5, 5.5, 7.5))

   def test_add_colors2(self):
      c1 = Color(1.0, 1.0, 1.0)
      c2 = Color(1.0, 2.0, 3.0)
      self.assertEqual(add_colors(c1, c2), Color(2.0, 3.0, 4.0))

   def test_ref(self):
      l = Vector(1.0, 1.0, 1.0)
      dot = 2.0
      n = Vector(1.0, 2.0, 3.0)
      self.assertEqual(ref(l, dot, n), Vector(-3.0, -7.0, -11.0))

   def test_ref2(self):
      l = Vector(1.0, -1.0, 0.0)
      dot = 1.0
      n = Vector(1.0, 2.0, 3.0)
      self.assertEqual(ref(l, dot, n), Vector(-1.0, -5.0, -6.0))

   def print_colors(self):
      c = Color(1.0, 2.0, 0.5)
      self.assertEqual(255, 255, 127.5)

   def print_colors2(self):
      c = Color(-1.0, 0.0, 1.0)
      self.assertEqual(-255, 0, 255)


if __name__ == "__main__":
     unittest.main()
