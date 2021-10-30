(defproject guessing-game "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "I DON'T CARE LICENSE"
            :url "https://github.com/jusdepatate/i-dont-care_license"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot guessing-game.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
