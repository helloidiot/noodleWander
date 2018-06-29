import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class randomWalk3D_02 extends PApplet {

float xtime = 100;
float ytime = 1000;
float ztime = 0.1f;

public void setup()
{
  

  stroke(random(80, 90));
  for (int i = 0; i < width; i = i + 5){
    for (int j = 0; j < height; j = j + 5){
      point(i + random(0, 10), j + random(0, 10));
    }
  }
}

public void draw()
{



  lights();

  float nx = noise(xtime);
  float ny = noise(ytime);
  float nz = noise(ztime);

  float x = map(nx, 0, 1, 200, width-100);
  float y = map(ny, 0, 1, 100, width-100);
  float z = map(nz, 0, 1, 300, -600);

  float r = map(x, 200, width-100, 0, 255);
  float b = map(y, 100, width-100, 0, 255);
  float g = map(z, 300, -600, 0, 255);

  translate(x, y, z);
  stroke(r, g, b);
  noFill();
  sphere(30);

  xtime += 0.01f;
  ytime += 0.01f;
  ztime += 0.01f;
}
  public void settings() {  size(600, 600, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "randomWalk3D_02" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
