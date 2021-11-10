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
	int fp;
	int p, bytesleidos;
	char saludo[] = "Un saludo !!!!!\n", buffer [10];

	while (1) { // bucle infinito
		fp = open ("FIFO2", 0); //FIFO2 en modo lectura
		bytesleidos = read(fp, buffer, 1);
		printf("Obteniendo información...\n"); 
		while (bytesleidos != 0) {
			printf("%s", buffer);
			bytesleidos = read (fp, buffer, 1); 
	}
	close (fp);
}
return(0);
}