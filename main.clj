(ns countdig.core
  (:require [clojure.test :refer :all]
            [clojure.string :refer :all]))

;; === Implementation  ===

(defn nb-dig [n d]
  """
  Return the number of times digit `d` appears in the sequence 
  k**2, for k in [0, n] where n is an argument.
  """
  (def digit-as-regex (re-pattern d))
  (def k-sequence (map (fn [x] (* x x)) (range (inc n))))
  (def k-sequence-as-string (map str k-sequence))
  (def count-list 
    (map 
      (fn [number-as-string] 
        (count (re-seq digit-as-regex number-as-string)))
      k-sequence-as-string))
  (reduce + count-list)
)

;; === Testing ===

(defn test-assert [act exp]
  (is (= act exp)))
  
(deftest a-test1
  (testing "nb-dig"
    (test-assert (nb-dig 10, 1) 4)
    (test-assert (nb-dig 1, 1) 1)
    (test-assert(nb-dig 25, 1), 11)
    (test-assert(nb-dig 11011, 2), 9481)
    (test-assert(nb-dig 12224, 8), 7733)
    (test-assert(nb-dig 11549, 1), 11905)
))

(run-tests)