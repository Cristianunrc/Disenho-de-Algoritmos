-- EJERCICIO 3
-- Dado un conjunto de citas y una fecha particular, encontrar el subconjunto
-- de tareas compatibles de prioridad maximal. Tener en cuenta hora inicio y hora fin de la cita
-- Prioridad: Cada cita tiene una prioridad (nivel de importancia), si se solapan dos o mas citas
-- se elige aquella cita con mayor prioridad.

-- Dada una lista, retorna el subsegmento de suma maxima.
cita :: [Int] -> Int
cita = maximum . map sum . subSegmento
-- fn = f . g . h es lo mismo que escribir fn x = f (g (h x))

-- Toma una lista y retorna sublistas con elementos consecutivos de la lista (subsegmentos).
subSegmento :: [Int] -> [[Int]]
subSegmento [] = [[]]
subSegmento ls@(x:xs) = subSegmento xs ++ tail (inits ls) -- ¿ ls@(x:xs) ??


-- Toma una lista y retorna sublistas, donde a cada una le va agregando el elemento en la
-- posicion corriente
-- Ej : inits [1,2,3] = [[], [1], [1,2], [1,2,3]]
inits :: [Int] -> [[Int]]
inits [] = [[]]
inits (x:xs) = [] : map (x :) (inits xs)