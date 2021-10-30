(ns guessing-game.core
  (:gen-class))

(defmacro recur-read
  "Macro for recurring from loop"
  [stri counter]
  `(do
     (println ~stri)
     (recur (read-line)
            ~counter)))

(defn roll-num
  "Roll between x and y, cast to integer"
  ([x y]
  (let [diff (+ 1(- y x))]
    (int (+ x (rand diff)))))
  ([x]
   (int (+ 1 (rand x)))))

(defn str->int
  "Syntatic sugar for converting STR to INT"
  [str]
  (Integer. str))

(defn sanitize
  "Check if input contains only numbers"
  [str]
  (re-matches #"[0-9]+" str))



(defn -main
  "Main FN where looping happens, and asks for number"
  []
  ;; Local assignment, one roll
  (let [rolledNum (roll-num 0 100)]
    (print "Welcome!\n"
           "Guess a number between 0 and 100: ")
    (print rolledNum)
    (loop [inputNum (read-line)
           counter 0]
      (cond
        (nil? (sanitize inputNum)) (recur-read
                                    "Not a number" counter)
        (> (str->int inputNum) rolledNum) (recur-read
                                           "\nToo big" (+ counter 1))
        (< (str->int inputNum) rolledNum) (recur-read
                                           "\nToo small" (+ counter 1))
        :else (println "WIN" counter)))))
