//package renderer;
//
//import org.junit.jupiter.api.Test;
//
//import geometries.Sphere;
//import geometries.Triangle;
//import lighting.AmbientLight;
//import primitives.*;
//import scene.Scene;
//
//import static java.awt.Color.*;
//
///** Test rendering a basic image
// * @author Dan */
//public class RenderTests {
//
//   /** Produce a scene with basic 3D model and render it into a png image with a
//    * grid */
//   @Test
//   public void basicRenderTwoColorTest() {
//      Scene scene = new Scene("Test scene")//
//         .setAmbientLight(new AmbientLight(new Color(255, 191, 191), //
//                                           new Double3(1, 1, 1))) //
//         .setBackground(new Color(75, 127, 90));
//
//      scene.getGeometries().add(new Sphere(50d, new Point(0, 0, -100)),
//                           new Triangle(new Point(-100, 0, -100), new Point(0, 100, -100), new Point(-100, 100, -100)), // up
//                           // left
//                           new Triangle(new Point(-100, 0, -100), new Point(0, -100, -100),
//                                        new Point(-100, -100, -100)), // down
//                           // left
//                           new Triangle(new Point(100, 0, -100), new Point(0, -100, -100), new Point(100, -100, -100))); // down
//      // right
//      Camera camera = new Camera(Point.ZERO, new Vector(0, 0, -1), new Vector(0, 1, 0)) //
//         .setVPDistance(100) //
//         .setVPSize(500, 500) //
//         .setImageWriter(new ImageWriter("base render test", 1000, 1000))
//         .setRayTracer(new RayTracerBasic(scene));
//
//      camera.renderImage();
//      camera.printGrid(100, new Color(YELLOW));
//      camera.writeToImage();
//   }
//
//   /** Produce a scene with basic 3D model - including individual lights of the
//    * bodies and render it into a png image with a grid */
//    @Test
//    public void basicRenderMultiColorTest() {
//    Scene scene = new Scene("Test scene")//
//    .setAmbientLight(new AmbientLight(new Color(WHITE), new Double3(0.2))); //
//
//    scene.geometries.add( //
//    new Sphere(50, new Point(0, 0, -100)),
//    // up left
//    new Triangle(new Point(-100, 0, -100), new Point(0, 100, -100), new
//    Point(-100, 100, -100))
//    .setEmission(new Color(GREEN)),
//    // down left
//    new Triangle(new Point(-100, 0, -100), new Point(0, -100, -100), new
//    Point(-100, -100, -100))
//    .setEmission(new Color(RED)),
//    // down right
//    new Triangle(new Point(100, 0, -100), new Point(0, -100, -100), new
//    Point(100, -100, -100))
//    .setEmission(new Color(BLUE)));
//
//    Camera camera = new Camera(Point.ZERO, new Vector(0, 0, -1), new Vector(0, 1,
//    0)) //
//    .setVPDistance(100) //
//    .setVPSize(500, 500) //
//    .setImageWriter(new ImageWriter("color render test", 1000, 1000))
//    .setRayTracer(new RayTracerBasic(scene));
//
//    camera.renderImage();
//    camera.printGrid(100, new Color(WHITE));
//    camera.writeToImage();
//    }
//}

package renderer;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import lighting.AmbientLight;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;

//import java.util.List;

//import static java.awt.Color.*;
import static java.awt.Color.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test rendering a basic image
 *
 * @author Dan
 */
public class RenderTests {

    /**
     * Produce a scene with basic 3D model and render it into a png image with a
     * grid
     */
    @Test
    public void basicRenderTwoColorTest() {
        Scene scene = new Scene.SceneBuilder("Test scene")//
                .setAmbientLight(new AmbientLight(new Color(255, 191, 191), new Double3(1, 1, 1))) //
                .setBackground(new Color(75, 127, 90))
                .build();

        scene.getGeometries().add(new Sphere(50d, new Point(0, 0, -100)),
                new Triangle(new Point(-100, 0, -100), new Point(0, 100, -100), new Point(-100, 100, -100)), // up
                // left
                new Triangle(new Point(-100, 0, -100), new Point(0, -100, -100), new Point(-100, -100, -100)), // down
                // left
                new Triangle(new Point(100, 0, -100), new Point(0, -100, -100), new Point(100, -100, -100))); // down
        // right
        Camera camera = new Camera(Point.ZERO, new Vector(0, 0, -1), new Vector(0, 1, 0)) //
                .setVPDistance(100) //
                .setVPSize(500, 500) //
                .setImageWriter(new ImageWriter("base render test", 1000, 1000))
                .setRayTracer(new RayTracerBasic(scene));

        camera.renderImage();
        camera.printGrid(100, new Color(YELLOW));
        camera.writeToImage();
    }

    @Test
    void testRedtriangle() {
        Scene scene = new Scene.SceneBuilder("Test scene")//
                .setAmbientLight(new AmbientLight(new Color(WHITE), new Double3(0.2)))
                .build(); //

        scene.getGeometries().add( //
                new Triangle(new Point(-100, 0, -100), new Point(0, -100, -100), new Point(-100, -100, -100))
                        .setEmission(new Color(RED)));

        Camera camera = new Camera(Point.ZERO, new Vector(0, 0, -1), new Vector(0, 1, 0)) //
                .setVPDistance(100) //
                .setVPSize(500, 500) //
                .setImageWriter(new ImageWriter("red triangle render test", 1000, 1000))
                .setRayTracer(new RayTracerBasic(scene));

        camera.renderImage();
        camera.printGrid(100, new Color(WHITE));
        camera.writeToImage();
    }
}

