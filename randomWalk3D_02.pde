float xtime = 100;
float ytime = 1000;
float ztime = 0.1;

void setup()
{
  size(600, 600, P3D);

  stroke(random(80, 90));
  for (int i = 0; i < width; i = i + 5){
    for (int j = 0; j < height; j = j + 5){
      point(i + random(0, 10), j + random(0, 10));
    }
  }
}

void draw()
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

  xtime += 0.01;
  ytime += 0.01;
  ztime += 0.01;
}
