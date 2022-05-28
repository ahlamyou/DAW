# DAW
1.CREAR REPOSITORIO EN GITHUB.COM
2.CREAR CARPETA DONDE CLONAR EL REPOSITORIO 
3.CLONAR EL REPOSITORIO CON CMD
	-CON EL COMANDO git clone urlRepositorio(EN GITHUB: BOTON VERDE CODE- HTTPS- COPIAR)
         EJ. git clone https://github.com/ahlamyou/DAW.git
	 Se ha clonado en la carpeta creda.
4.ENTRAMOS CON CD EN LA CARPETA CREADA
	-UTILIZAMOS EL COMANDO git init PARA CREAR DIRETORIO OCULTO DONDE SE GUARDARAN LOS CAMBIOS DEL REPOSITORIO LOCAL
5.CREAR UNA RAMA: 
	ESTANDO EN LA CARPETA CREADA COMANDO git checkout -b nombreRama 
6.COMANDOS VER RAMAS LOCALES, REMOTAS Y A LA QUE ESTOY CONECTADO:
	git branch -a
7.COMO CAMBIAR DE RAMA DESDE EL CMD:
	git switch nombreRama
8.PASOS PARA SUBIR UN CAMBIO EN LA RAMA EN LA QUE ESTAS
	git diff		*para visualizar los cambios realizados
	1.git add . 		*para añadir todos los cambios
	2.git add nombreArchivo *para añadir los cambios de un archivo en concreto
	3.git commit -m "mensaje explicativo de los cambios"

TOKEN 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
git push https://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@github.com/ahlamyou/DAW