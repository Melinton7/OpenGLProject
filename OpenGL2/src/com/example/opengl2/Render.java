package com.example.opengl2;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;
import android.view.MotionEvent;

public class Render implements Renderer {

	/** Triangle instance /
	private Triangle triangle;
	/** Square instance /
	private Square square;
	
	/** Pyramid instance */
	private Techo techo;
	/** Cube instance */
	private Casa casa;
	private Puerta puerta;
	
	private Hojas hojas;
	private Tronco tronco;
	
	
	/** Angle For The Pyramid */
	private float rtri; 	
	/** Angle For The Cube */
	private float rquad; 
	
	/**
	 * Instance the Triangle and Square objects
	 */
	public Render() {
		techo = new Techo();
		casa = new Casa();
		hojas = new Hojas();
		tronco = new Tronco();
		puerta = new Puerta();
	}
	
	/**
	 * The Surface is created/init()
	 */
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {		
		gl.glShadeModel(GL10.GL_SMOOTH); 			//Enable Smooth Shading
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f); 	//Black Background
		gl.glClearDepthf(1.0f); 					//Depth Buffer Setup
		gl.glEnable(GL10.GL_DEPTH_TEST); 			//Enables Depth Testing
		gl.glDepthFunc(GL10.GL_LEQUAL); 			//The Type Of Depth Testing To Do
		
		//Really Nice Perspective Calculations
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST); 
	}
	
	/**
	 * Here we do our drawing
	 */
	public void onDrawFrame(GL10 gl) {
		//Clear Screen And Depth Buffer
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);	
		gl.glLoadIdentity();					//Reset The Current Modelview Matrix
		
		/*
		 * Minor changes to the original tutorial
		 * 
		 * Instead of drawing our objects here,
		 * we fire their own drawing methods on
		 * the current instance
		 */
		gl.glTranslatef(-2.0f, -1.2f, -10.0f);	//Move down 1.2 Unit And Into The Screen 6.0
		//gl.glScalef(0.8f,0.8f,0.8f);
		gl.glRotatef(rquad, 1.0f, 1.0f, 0.0f);
		casa.draw(gl);						//Draw the square
				
		//Reset Modelview
		//gl.glLoadIdentity();
		//gl.glTranslatef(0.0f, 0.0f, 0.0f);
		puerta.draw(gl);
		
		//Techo
		gl.glTranslatef(0.0f, 2.0f, 0.0f);//-2.0f, 0.8f, -10.0f);		
		//gl.glRotatef(rtri, 0.0f, 1.0f, 0.0f);
		techo.draw(gl);						//Draw the triangle	
		
		//Reset
		gl.glLoadIdentity();
		
		//Tronco
		gl.glTranslatef(2.0f, -1.2f, -10.0f);
		//gl.glRotatef(rquad, 1.0f, 1.0f, 0.0f);
		tronco.draw(gl);		
		
		//Hojas
		gl.glTranslatef(0.0f, 2.0f, 0.0f);
		hojas.draw(gl);
		
		
		
		
		rtri +=0.5f;
		rquad += 0.5f;
	}	
	
	/**
	 * If the surface changes, reset the view
	 */
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		if(height == 0) { 						//Prevent A Divide By Zero By
			height = 1; 						//Making Height Equal One
		}

		gl.glViewport(0, 0, width, height); 	//Reset The Current Viewport
		gl.glMatrixMode(GL10.GL_PROJECTION); 	//Select The Projection Matrix
		gl.glLoadIdentity(); 					//Reset The Projection Matrix

		//Calculate The Aspect Ratio Of The Window
		GLU.gluPerspective(gl, 45.0f, (float)width / (float)height, 0.1f, 100.0f);

		gl.glMatrixMode(GL10.GL_MODELVIEW); 	//Select The Modelview Matrix
		gl.glLoadIdentity(); 					//Reset The Modelview Matrix
	}
	
	/* ***** Listener Events ***** */	
	/**
	 * Override the touch screen listener.
	 * 
	 * React to moves and presses on the touchscreen.
	 */
	public boolean onTouchEvent(MotionEvent event) {
		//
		float x = event.getX();
        float y = event.getY();
        
        //A press on the screen
        if(event.getAction() == MotionEvent.ACTION_UP) {
        	//gl.glRotatef(rtri, 0.0f, 1.0f, 0.0f);
    		//techo.draw(gl);	
        }
        
        //We handled the event
		return true;
	}
	
	

}
