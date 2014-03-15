package com.example.opengl2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Casa {
	
	/** The buffer holding the vertices */
	private FloatBuffer vertexBuffer;
	/** The buffer holding the color values */
	private FloatBuffer colorBuffer;
	/** The buffer holding the indices */
	private ByteBuffer  indexBuffer;
	
	/** 
	 * The initial vertex definition
	 * 
	 * It defines the eight vertices a cube has
	 * based on the OpenGL coordinate system
	 **/
	private float vertices[] = {
			            -1.0f, -1.0f, -1.0f,	//lower back left (0)
			            1.0f, -1.0f, -1.0f,		//lower back right (1)
			            1.0f,  1.0f, -1.0f,		//upper back right (2)
			            -1.0f, 1.0f, -1.0f,		//upper back left (3)
			            -1.0f, -1.0f,  1.0f,	//lower front left (4)	
			            -0.35f, -1.0f, 1.0f,	//lower door left (5)
			            -0.35f, 0.25f, 1.0f,	//upper door left (6)
			            0.35f, 0.25f, 1.0f,		//upper door right (7)
			            0.35f, -1.0f, 1.0f,		//lower door right (8)			            
			            1.0f, -1.0f,  1.0f,		//lower front right (9)
			            1.0f, 0.25f, 1.0f,		//mid wall right (10)			            
			            1.0f,  1.0f,  1.0f,		//upper front right (11)
			            -1.0f,  1.0f,  1.0f,	//upper front left (12)
			            -1.0f, 0.25f, 1.0f,		//mid wall left (13)
			    							};
	/** The initial vertex definition 
	private float vertices[] = { 						 
						 1.0f, 1.0f, 1.0f,		//Top Right of Wall (Front)
						-1.0f,  1.0f, 1.0f,		//Top Left Of Wall (Front)
						-1.0f, -1.0f, 1.0f,		//Bottom Left Of Wall (Front)
						-0.25f,-1.0f, 1.0f,		//Bottom Left of Door (Front)
						-0.25f, 0.25f, 1.0f,	//Top Left of Door (Front)
						0.25f, 0.25f, 1.0f,		//Top Right of Door (Front)
						0.25f, -1.0f,1.0f,		//Bottom Right of Door (Front)
						1.0f, -1.0f, 1.0f,		//Bottom Right Of Wall (Front)
						 
						1.0f, 1.0f, -1.0f,		//Top right of Wall (Right side)
						1.0f, 1.0f, 1.0f,		//Top left of Wall (Right side)
						 1.0f, -1.0f, 1.0f,		//Bottom left of wall (Right side)		
						 1.0f, -1.0f, -1.0f,	//Bottom right of wall (Right side)						 
						 
						 1.0f, 1.0f, -1.0f,		//Top right of Wall (Back)
						 -1.0f, 1.0f, -1.0f,	//Top left of Wall (Back)
						 -1.0f, -1.0f, -1.0f,	//Bottom left of wall (Back)
						 1.0f, -1.0f, -1.0f,	//Bottom right of wall (Back)
						 
						 -1.0f, 1.0f, 1.0f,		//Top right of wall (Left side)	
						 -1.0f, 1.0f, -1.0f,	//Top left of wall (Left side)
						 -1.0f, -1.0f, -1.0f,	//Bottom left of wall (Left side)
						 -1.0f, -1.0f, 1.0f,	//Bottom right of wall (Left side)						 					 
						 
						 1.0f, 1.0f, 1.0f, 		//Top right of Ceiling (Top)
						 -1.0f, 1.0f, 1.0f, 	//Top left of Ceiling (Top)
						 -1.0f, 1.0f, -1.0f,	//Bottom left of Ceiling (Top)
						 1.0f, 1.0f, -1.0f,		//Bottom right of Ceiling (Top)
						 						
	};*/
    
    /** The initial color definition */	
	private float colors[] = {
			            0.0f,  1.0f,  0.0f,  1.0f,
			            0.0f,  1.0f,  0.0f,  1.0f,
			            1.0f,  0.5f,  0.0f,  1.0f,
			            1.0f,  0.5f,  0.0f,  1.0f,
			            1.0f,  0.0f,  0.0f,  1.0f,
			            1.0f,  0.0f,  0.0f,  1.0f,
			            0.0f,  0.0f,  1.0f,  1.0f,
			            1.0f,  0.0f,  1.0f,  1.0f
			    								};
	
	/** 
     * The initial indices definition
     * 
     * The indices define our triangles.
     * Always two define one of the six faces
     * a cube has.
     *	*/
	private byte indices[] = {
    					/*
    					 * Example: 
    					 * Face made of the vertices lower back left (lbl),
    					 * lfl, lfr, lbl, lfr, lbr
    					 **/
			            0, 4, 9,    0, 9, 1,
			            //and so on...
			            1, 9, 11,    1, 11, 2,
			            2, 11, 12,    2, 12, 3,
			            3, 12, 4,    3, 4, 0,
						12, 13, 10,		12, 10, 11,
						13, 4, 5,		13, 5, 6,
						7, 8, 9,		7, 9, 10,												
			            3, 0, 1,    3, 1, 2
    										};
	
	/**
	 * The Cube constructor.
	 * 
	 * Initiate the buffers.
	 */
	public Casa() {
		//
		ByteBuffer byteBuf = ByteBuffer.allocateDirect(vertices.length * 4);
		byteBuf.order(ByteOrder.nativeOrder());
		vertexBuffer = byteBuf.asFloatBuffer();
		vertexBuffer.put(vertices);
		vertexBuffer.position(0);
		
		//
		byteBuf = ByteBuffer.allocateDirect(colors.length * 4);
		byteBuf.order(ByteOrder.nativeOrder());
		colorBuffer = byteBuf.asFloatBuffer();
		colorBuffer.put(colors);
		colorBuffer.position(0);
		
		/**/
		indexBuffer = ByteBuffer.allocateDirect(indices.length);
		indexBuffer.put(indices);
		indexBuffer.position(0);
	}
	
	/**
	 * The object own drawing function.
	 * Called from the renderer to redraw this instance
	 * with possible changes in values.
	 * 
	 * @param gl - The GL Context
	 */
	public void draw(GL10 gl) {		
		//Set the face rotation
		gl.glFrontFace(GL10.GL_CW);
		
		//Point to our buffers
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		//gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
		
		//Enable the vertex and color state
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		//gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glColor4f(0.933f, 0.910f, 0.667f, 1.0f);		
		
		//Draw the vertices as triangles, based on the Index Buffer information
		gl.glDrawElements(GL10.GL_TRIANGLES, 48, GL10.GL_UNSIGNED_BYTE, indexBuffer);
		//gl.glDrawArrays(GL10.GL_TRIANGLES, 0, vertices.length / 3);
		
		//Disable the client state before leaving
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}
}
