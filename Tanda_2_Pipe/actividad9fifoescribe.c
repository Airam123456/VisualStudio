//actividad9fifoescribe.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>


int main (void)
{
	int fd;
	int p, bytesleidos;
	char saludo[] = "Obteniendo información....Un saludo....\n";

	fd = open ("FIFOAiram", 1); /// abrimos fifo con permiso de escritura

	if (fd == -1) {
		printf("Error al abrir el fichero... \n");
 		exit (1);
	}

	printf("Mandando información al FIFO...\n");
	write (fd, saludo, sizeof(saludo)); 	
	close (fd);
	return(0);
}