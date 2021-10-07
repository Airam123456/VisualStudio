//actividad9fifocrea.c
#define _DEFAULT_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>


int main (void)
{
	int fd; //file decriptor
	int pipe, bytesleidos; // 
	char buffer [100]; //buffer de tamanio 100

	pipe=mknod("FIFOAiram", S_IFIFO|0666, 0); /// creamos la pipe con permisos de lectura y escritura, por ello ponemos el 666
	
	if (pipe== -1) {
		printf("Ha ocurrido un error.... \n"); // recuerda borrarlo la segunda vez...
		exit (0);
	}

	while (1) {
		fd = open ("FIFOAiram", 0); // abrimos el file decriptor con permiso de lectura
		bytesleidos = read(fd, buffer, 1); // vamos leyendo byte a byte del buffer
		printf("Obteniendo información...\n"); 
		while (bytesleidos != 0) {
			printf("%s", buffer); //vamos escribiendo byte a byte segun los vamos leyendo
			bytesleidos = read (fd, buffer, 1); // leo otro byte
	    }
	    close (fd); // cerramos el file decriptor
    }   
    return(0);
}   