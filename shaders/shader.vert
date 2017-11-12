#version 330 core

layout (location = 0) in vec4 position;
layout (location = 1) in vec2 tc;

uniform mat4 pr_matrix;
uniform mat4 tr_matrix;
uniform mat4 rt_matrix;

out DATA
{
	vec2 tc;
} vs_out;


void main()
{	
	gl_Position = pr_matrix * tr_matrix * rt_matrix * position;	
	vs_out.tc = tc;
}