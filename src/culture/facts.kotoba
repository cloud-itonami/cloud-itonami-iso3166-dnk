(ns culture.facts
  "Country-level regional-culture catalog for Denmark (DNK) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"DNK"
   [{:culture/id "dnk.dish.smorrebrod"
     :culture/name "Smørrebrød"
     :culture/country "DNK"
     :culture/kind :dish
     :culture/summary "Traditional open-faced sandwich in the cuisines of Denmark, Norway and Sweden: buttered dense dark rye bread (rugbrød) topped with cold cuts, meat or fish, cheese or spreads, and garnishes."
     :culture/url "https://en.wikipedia.org/wiki/Sm%C3%B8rrebr%C3%B8d"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dnk.dish.stegt-flaesk"
     :culture/name "Stegt flæsk"
     :culture/country "DNK"
     :culture/kind :dish
     :culture/summary "Fried pork belly generally served with potatoes and parsley sauce; the national dish of Denmark and one of the country's most popular foodstuffs."
     :culture/url "https://en.wikipedia.org/wiki/Stegt_fl%C3%A6sk"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dnk.dish.frikadeller"
     :culture/name "Frikadeller"
     :culture/country "DNK"
     :culture/kind :dish
     :culture/summary "Rounded, flat-bottomed pan-fried meatballs of ground meat; the origin is uncertain (supposedly Denmark or Germany), and the dish is associated with German, Nordic and Eastern European cuisines."
     :culture/url "https://en.wikipedia.org/wiki/Frikadeller"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dnk.dish.danish-pastry"
     :culture/name "Danish pastry"
     :culture/country "DNK"
     :culture/kind :dish
     :culture/summary "Multilayered, laminated sweet pastry; bakery techniques brought to Denmark by Austrian bakers after an 1850 bakery strike were adapted by Danish bakers into a Danish specialty."
     :culture/url "https://en.wikipedia.org/wiki/Danish_pastry"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dnk.beverage.akvavit"
     :culture/name "Akvavit"
     :culture/country "DNK"
     :culture/kind :beverage
     :culture/summary "Distilled spirit principally produced in Scandinavia since the 15th century; in Denmark it is called snaps or akvavit and is primarily consumed at Christmas and Easter lunches."
     :culture/url "https://en.wikipedia.org/wiki/Akvavit"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dnk.craft.royal-copenhagen"
     :culture/name "Royal Copenhagen"
     :culture/name-local "Den Kongelige Porcelænsfabrik"
     :culture/country "DNK"
     :culture/kind :craft
     :culture/summary "Danish manufacturer of porcelain products, founded in Copenhagen in 1775 under the protection of Danish Dowager Queen Juliane Marie."
     :culture/url "https://en.wikipedia.org/wiki/Royal_Copenhagen"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dnk.festival.roskilde-festival"
     :culture/name "Roskilde Festival"
     :culture/country "DNK"
     :culture/kind :festival
     :culture/summary "Danish music festival held annually south of Roskilde since 1971, one of the largest music festivals in Europe and the largest in the Nordic countries."
     :culture/url "https://en.wikipedia.org/wiki/Roskilde_Festival"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dnk.heritage.kronborg"
     :culture/name "Kronborg"
     :culture/country "DNK"
     :culture/kind :heritage
     :culture/summary "Castle and historical stronghold in Helsingør, Denmark, immortalised as Elsinore in Shakespeare's Hamlet; inscribed on the UNESCO World Heritage List in 2000."
     :culture/url "https://en.wikipedia.org/wiki/Kronborg"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-iso3166-dnk culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "DNK"))
                 " DNK entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
