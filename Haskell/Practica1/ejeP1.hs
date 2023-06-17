-- PRACTICA 1
-- EJERCICIO 5

-- Decir si dos secuencias son anagramas (una es permutación de la otra) 

esAnagrama :: Eq a => [a] -> [a] -> Bool
esAnagrama xs ys = buscaTrue ([ x == y | x <- [xs], y <- permutacion ys])


-- busca un True en la lista y lo retorna, si no hay ningun True retorna False
buscaTrue :: [Bool] -> Bool
buscaTrue [] = False
buscaTrue (x:xs) | x == True = True
                 | otherwise = buscaTrue xs


-- toma una lista de elementos y devuelve una lista con todas las permutaciones posibles de la lista dada
permutacion :: [a] -> [[a]]
permutacion [] = [[]]
permutacion (x:xs) = concat [intercala x ys | ys <- permutacion xs]


-- toma un elemento y una lista de elementos e intercala el elemento en cada posicion de la lista
-- intercala 2 [1,3] = [[2,1,3], [1,2,3], [1,3,2]]
intercala :: a -> [a] -> [[a]]
intercala x [] = [[x]]
intercala x (y:ys) = (x:y:ys) : [y:zs | zs <- intercala x ys]

--------------------------------------------------------------------------

-- Dadas dos cadenas p y s, decida si p es subcadena de s.

subCadena :: String -> String -> Bool
subCadena _ [] = True
subCadena [] ys = False
subCadena xs ys = esPrefijo ys xs || subCadena (tail xs) ys


esPrefijo :: Eq a => [a] -> [a] -> Bool
esPrefijo [] _ = True
esPrefijo xs [] = False
esPrefijo (x:xs) (y:ys) | x == y = esPrefijo xs ys 
                        | otherwise = False

-- isPrefixOf [1,2] [1,2,3] = True
-- isPrefixOf [2] [2,3] = True
-- isPrefixOf [3] [4,5] = False
-- Tambien se puede hacer con listas de caracteres

--------------------------------------------------------------------

-- Dado un conjunto de enteros y un numero entero, decir si existe algun subconjunto 
-- tal que su suma sea igual al numero dado

-- Dice si existe algun subconjunto tal que su suma sea igual al numero dado
sumaSubSet :: Int -> [Int] -> Bool
sumaSubSet n xs = [ys | ys <- subSet xs, sum ys == n] /= [] -- el /=[] se usa para evitar
                                                            -- la comparacion entre [] == 0,
                                                            -- ya que daria un error.

-- Toma una lista de enteros (conjunto de enteros) y retorna una lista de listas de enteros
-- (los subconjuntos del conjunto)
subSet :: [Int] -> [[Int]]
subSet [] = [[]]
subSet (x:xs) = subSet xs ++ [x:ys | ys <- subSet xs]


-----------------------------------------------------------------------

-- Dadas dos cadenas p y s, decir si p es subsecuencia de s (donde los elementos no necesariamente
-- deben estar contiguos)

-- Dice si la segunda cadena esta dentro de la primera (una subsecuencia)
subSec :: Eq a => [a] -> [a] -> Bool
subSec _ [] = True
subSec [] ys = False
subSec (x:xs) (y:ys) | x == y = subSec xs ys -- si x == y se hace recursion sobre ambas cadenas
                     | otherwise = subSec xs (y:ys) -- si x /=y solo se hace recusion sobre la primer cadena


-------------------------------------------------
-- EJERCICIO 7
-- realice un algoritmo que elimine elementos repetidos de una lista.

eliminaRepetidos :: Eq a => [a] -> [a]
eliminaRepetidos [] = []
eliminaRepetidos (x:xs) | pertenece x xs = eliminaRepetidos xs
                        | otherwise = x : eliminaRepetidos xs


-- dice si un elemento n pertenece a una lista
-- Ecuacion de recurrencia: 
-- T(1) = 1
-- T(n) = T(n-1) 
pertenece :: Eq a => a -> [a] -> Bool
pertenece n [] = False
pertenece n (x:xs) = n == x || pertenece n xs 



---------------------------------------------------

-- Ejercicio 4 Parcial 2016
-- logs "hola" "ha" "oa"  TRUE
-- logs "hola" "la" "da"  FALSE
logs :: Eq a => [a] -> [a] -> [a] -> Bool
logs xs ys zs = subSec xs ys && subSec xs zs      


------------------------------------------

-- Ejercicio 2 Parcial 2016

-- dice si existe algun subconjunto de la lista de enteros cuya suma sea igual a cero.
-- Se reutiliza la funcion subSet.
rutinaBalanceada :: [Int] -> Int -> Bool
rutinaBalanceada xs n = [balan | balan <- subSet xs, sum balan == 0 ] /= []


----------------------------------------------------
-- Ejercicio 1 Parcial 2016

clave :: [Int] -> Int -> [[Int]]
clave [] _ = [[]]
clave (x:xs) n | length (x:xs) == n = [(x:xs)]

------------------------------------------------------

-- Ejercicio 4 Parcial 2023
-- Dado un arbol binario, devolver la longitud de la rama mas corta y la rama mas larga

-- HACERLO!
