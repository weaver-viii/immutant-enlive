(defproject immutant_enlive "0.1.0-SNAPSHOT"
  :description "learning application to use Enlive templates on immutant"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 [org.clojure/clojure "1.4.0"] 
                 [org.timmc/enlive "1.2.0-alpha1"] 
                 [net.cgrand/moustache "1.1.0" :exclusions [ring ring/ring-core]]
                ]
  :immutant {
             :nrepl-port 4212
            }
  )
