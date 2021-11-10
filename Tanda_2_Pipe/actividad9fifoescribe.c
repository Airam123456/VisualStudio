//actividad9fifoescribe.c
#define _DEFAULT_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>

int main (void)
{
	int fp;
	int p, bytesleidos;
	char saludo[] = "Un saludo !!!!!\n";
	p=mknod("FIFO2", S_IFIFO|0666, 0); /// permiso de lectura y escritura
	
	if (p== -1) {
		printf("Ha ocurrido un error.... \n"); // recuerda borrarlo la segunda vez...
		exit (0);
	}
	
	fp = open ("FIFO2", 1); 

	if (fp == -1) {
		printf("Error al abrir el fichero... \n");
 		exit (1);
	}
	printf("Mandando información al FIFO...\n");
	write (fp, saludo, sizeof(saludo)); 	
	close (fp);
	return(0);
}