//actividad9fifoescribe.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>


int main (void)
{
	int fd; //file decriptor
	char saludo[] = "Obteniendo información....Un saludo....\n"; //saludo

	fd = open ("FIFOAiram", 1); /// abrimos fifo con permiso de escritura

	if (fd == -1) { //si es -1 hay un error
		printf("Error al abrir el fichero... \n");
 		exit (1);
	}

	printf("Mandando información al FIFO...\n");
	write (fd, saludo, sizeof(saludo)); 	//escribimos en la pipe
	close (fd); //cerramos
	return(0);
}