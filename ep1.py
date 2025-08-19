def SumaLista(arreglo):
    suma=0
    for i in range (0,5,1):
        suma=suma+arreglo[i]
    return suma

arreglo=[1,3,5,7,9]
print("Suma: ", SumaLista(arreglo))