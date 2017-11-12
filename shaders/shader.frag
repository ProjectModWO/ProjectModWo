#version 330 core

out vec4 color;

in DATA
{
	vec2 tc;
} fs_in;

uniform sampler2D tex;

void main() 
{
	color = texture(tex, fs_in.tc);
	if(color.a < 0.5)
    discard;
}