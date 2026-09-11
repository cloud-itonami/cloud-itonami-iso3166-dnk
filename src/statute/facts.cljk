(ns statute.facts
  "General-law compliance catalog for Denmark (DNK) -- extends this repo's
  existing `marketentry.facts` (public-procurement market-entry only,
  narrow scope) with a second, orthogonal catalog of statutes a company
  generally must track for compliance. Mirrors
  cloud-itonami-iso3166-jpn/-usa/-esp/-swe/-nor's `statute.facts`
  (ADR-2607141700, cloud-itonami-compliance-fact-federation).

  Only TWO entries, not three -- honestly reflecting a real dead-end.
  retsinformation.dk (Denmark's official legal database, and the
  authoritative source for Selskabsloven, the Companies Act) returned
  HTTP 403 to WebFetch on every URL form tried (the direct `eli/lta`
  page, its `/pdf` variant); erhvervsstyrelsen.dk (the Danish Business
  Authority responsible for administering the Act) also returned 403 on
  every page tried; businessindenmark.virk.dk rendered but had no
  substantive legal content (JS-only shell). Rather than fabricate a
  corporate-governance citation from search-snippet text alone, this
  catalog omits that topic for Denmark entirely -- a rule not in this
  table has NO spec-basis, full stop; extend `catalog`, do not invent an
  id/url.

  The two entries below WERE independently WebFetch-verified: the
  Working Environment Act via at.dk (Arbejdstilsynet, the Danish Working
  Environment Authority's own site, which explicitly labels its English
  text an \"unofficial version\" -- same discipline as Korea's KLRI
  translations, tagged with a distinct url-provenance rather than reused
  as :official-lovdata-equivalent); the Data Protection Act via a
  Datatilsynet (the Danish Data Protection Agency)-hosted official
  English-translation PDF, verified by directly reading the PDF's header
  (\"Act No. 502 of 23 May 2018\") via the Read tool -- body-text glyphs in
  that particular PDF render as boxes due to a font-subsetting artifact,
  but the header and section titles are legible in the rendered image.")

(def catalog
  "iso3 -> vector of statute entries."
  {"DNK"
   [{:statute/id "dnk.databeskyttelsesloven-2018"
     :statute/title "Danish Data Protection Act (Databeskyttelsesloven)"
     :statute/jurisdiction "DNK"
     :statute/kind :law
     :statute/law-number "Act No. 502 of 23 May 2018"
     :statute/url "https://cdn.datatilsynet.dk/datatilsynet/media/7753/danish-data-protection-act.pdf"
     :statute/url-provenance :official-datatilsynet
     :statute/enacted-date "2018-05-23"
     :statute/retrieved-at "2026-07-15"
     :statute/topic #{:data-protection :privacy}}
    {:statute/id "dnk.arbejdsmiljoloven"
     :statute/title "Working Environment Act (Arbejdsmiljøloven)"
     :statute/jurisdiction "DNK"
     :statute/kind :law
     :statute/law-number "Consolidated Act no. 2062 of 16 November 2021"
     :statute/url "https://at.dk/en/regulations/working-environment-act/"
     :statute/url-provenance :official-agency-unofficial-translation
     :statute/retrieved-at "2026-07-15"
     :statute/topic #{:labor :employment}}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-dnk statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "DNK")) " DNK statutes seeded, verified "
                 "against official at.dk/datatilsynet.dk citations "
                 "(retsinformation.dk and erhvervsstyrelsen.dk both 403'd, so "
                 "a corporate-governance entry was deliberately omitted rather "
                 "than fabricated). Extend `statute.facts/catalog`, never "
                 "fabricate a law-id or URL.")})))

(defn by-topic [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
