(ns marketentry.facts "Denmark market-entry catalog.")
(def catalog
  {"DNK" {:name "Denmark"
          :owner-authority "Konkurrence- og Forbrugerstyrelsen / Udbud.dk"
          :legal-basis "Udbudsloven; EU directives"
          :national-spec "Udbud.dk supplier registration + CVR"
          :provenance "https://www.udbud.dk/"
          :required-evidence ["CVR number record"
                              "Udbud.dk registration record"
                              "CVR extract"
                              "Authorized-representative record"]
          :rep-owner-authority "contracting authorities / KFST"
          :rep-legal-basis "EU establishment or Danish CVR entity for many procedures"
          :rep-provenance "https://www.udbud.dk/"
          :corporate-number-owner-authority "Erhvervsstyrelsen / CVR"
          :corporate-number-legal-basis "CVR-nummer"
          :corporate-number-provenance "https://datacvr.virk.dk/"}})

(defn spec-basis [iso3] (get catalog iso3))
(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note "R0 catalog seed"})))
(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))
(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))
(defn rep-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))
(defn corporate-number-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority :corporate-number-legal-basis :corporate-number-provenance]))))
