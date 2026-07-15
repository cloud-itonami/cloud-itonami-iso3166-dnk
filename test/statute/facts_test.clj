(ns statute.facts-test
  (:require [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest dnk-has-spec-basis
  (let [sb (facts/spec-basis "DNK")]
    (is (= 2 (count sb)))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["DNK" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["dnk.arbejdsmiljoloven"]
         (mapv :statute/id (facts/by-topic "DNK" :labor))))
  (is (empty? (facts/by-topic "DNK" :corporate-governance)))
  (is (empty? (facts/by-topic "ATL" :labor))))
