(ns layout.common
  (:use [net.cgrand.enlive-html] [clojure.pprint])
)

(def herd (html-resource "layout/form.html"))

(def layout (html-resource "layout/template.html"))
                            