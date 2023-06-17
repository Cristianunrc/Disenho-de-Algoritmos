-- PRACTICA 2

-- EJERCICIO 5
-- usando Divide & Conquer implemente programa que, dadas dos
-- secuencias de caracteres, construya la subsecuencia comun a ambas de longitud maxima. Se entiende
-- por subsecuencia una cadena de caracteres que se deriva de la original mediante la eliminacion de
-- caracteres pero sin cambiar el orden de los caracteres en la secuencia original.


-- funcion que dadas dos secuencias (cadenas), devuelve la subsecuencia (cadena) comun mas larga de ambas
-- secuencias, en realidad devuelve una secuencia (de todas las secuencia posibles).

-- scm = subsecuencia comun maxima
scm :: Eq a => [a] -> [a] -> [a]
scm [] _ = []
scm _ [] = []
scm (x:xs) (y:ys) | x == y = x : scm xs ys
                  | otherwise = mayorCadena (scm (x:xs) ys) (scm xs (y:ys))


-- devuelve la cadena con longitud maxima
mayorCadena :: Eq a => [a] -> [a] -> [a]
mayorCadena xs ys | length xs >= length ys = xs
                  | otherwise = ys  -- length xs < length ys

-----------------------------------------------------------------------
-- EJERCICIO 8
-- Diseñar un algoritmo que dada una lista de enteros positivos devuelva el menor y mayor elementos
-- de la lista, usando decrease and conquer

-- toma una lista y devuelve una tupla donde el primer elemento es el menor de la lista y
-- el segundo elemento es el mayor de la lista
menorMayor :: [Int] -> (Int, Int)
menorMayor [] = (0, 0)
menorMayor [x,y] | x < y = (x, y)
                 | otherwise = (y, x) 
menorMayor (x:xs) = (min x (fst p), max x (snd p)) -- p devuelve una tupla
                    where p = menorMayor xs


-- EJERCICIO 10
-- Utilizando Decrease & Conquer, diseñe un algoritmo para encontrar la distancia Hamming
-- entre dos cadenas de igual longitud.
-- Hamming toma dos cadenas (igual longiud) y cuenta la cantidad de caracteres que difiere 
-- la primer cadena de la segunda y retorna la cantidad

--hamming :: Eq a => [a] -> [a] -> Int
--hamming [] ys = 0
--hamming xs [] = 0
--hamming (x:xs) (y:ys) | x /= y = 1 + hamming xs ys
 --                     | otherwise = hamming xs ys

hamming :: Eq a => [a] -> [a] -> Int
hamming xs ys = if length xs /= length ys then error "must be the same length"
                else hammingAux xs ys

hammingAux :: Eq a => [a] -> [a] -> Int
hammingAux [] [] = 0
hammingAux (x:xs) (y:ys) | x /= y = 1 + hammingAux xs ys
                         | otherwise = hammingAux xs ys
        

-- EJERCICIO 11
-- Diseñar un algoritmo que dados dos numeros enteros calcule su producto con la tecnica
-- decrease and conquer con decremento por una constante (1) y ademas calcule la cantidad
-- de sumas que se computan.


-- toma dos enteros y devuelve una tupla, donde el primer elemento es el resultado del
-- producto y el segundo elemento es la cantidad de sumas que se ejecutan.
prodDecConst :: Int -> Int -> (Int, Int)
prodDecConst x y | x == 0 || y == 0 = (0, 0)
                 | otherwise = (x + fst (dec), 1 + snd (dec))
                    where dec = prodDecConst x (y - 1)



-- EJERCICIO 12
-- dadas dos secuencias p y t, determinar si p es subsecuencia de t (de elementos contiguos),
-- utilizando la tecnica decrease and conquer.

subSecDaC :: String -> String -> Bool
subSecDaC [] _ = True
subSecDaC _ [] = False
subSecDaC xs ys | xs == take (length xs) ys = True
                | otherwise = subSecDaC xs (tail ys) -- el decremento by one esta en (tail ys)