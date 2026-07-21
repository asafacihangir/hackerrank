# HackerRank Çözümleri

HackerRank problem çözümleri ve algoritma çalışma notları. Java 8, Maven.

Her problem kendi paketinde durur; test verileri paketin yanındaki `testdata/` klasöründedir. Bazı problemlerin birden fazla çözümü vardır (`App0`, `App1`, `App2` …) — farklı yaklaşımları karşılaştırmak için.

## Kurulum

```bash
git clone https://github.com/asafacihangir/hackerrank.git
cd hackerrank
mvn clean test
```

Java 8+ ve Maven gerekir.

## Çalıştırma

Çözümler dosya yollarını `System.getProperty("user.dir")` üzerinden kurar, bu yüzden **proje kökünden** çalıştırılmalıdır.

Tek dosyayı derleyip çalıştırmak için:

```bash
./run.sh src/main/java/com/cihangir/algorithms/_03/Solution01.java
```

Argüman verilmezse `algorithms/_03/Solution01.java` çalışır.

Tüm projeyi derlemek ve testleri koşmak için:

```bash
mvn clean test
```

## Paketler

Paketler HackerRank'in konu başlıklarını takip eder.

### `algorithms`

Test altyapılı çözümler. Her biri `testdata/` altındaki girdileri okur, beklenen sonuçla karşılaştırır ve `PASSED`/`FAILED` basar.

| Paket | Problem |
|---|---|
| `_01` | Forming a Magic Square |
| `_02` | 3Sum Closest (LeetCode 16) |
| `_03` | Non-Divisible Subset |

### `warm_challenges`

Isınma problemleri. Girdiler kod içinde sabit tutulur, ayrı test verisi yoktur.

| Paket | Problem |
|---|---|
| `_00_sales_by_match` | Sales by Match |
| `_01_counting_valleys` | Counting Valleys |
| `_02_jumping_on_the_clouds` | Jumping on the Clouds |
| `_03_repeated_string` | Repeated String |

### `dictionaries_and_hashmaps`

Hash tablosu ve sözlük problemleri. Bu paketin `src/test/java/` altında JUnit testleri vardır.

| Paket | Problem |
|---|---|
| `_00_hash_tables_ransom_note` | Hash Tables: Ransom Note |
| `_01_two_strings` | Two Strings |
| `_02_sherlock_and_anagrams` | Sherlock and Anagrams |
| `_03_count_triplets` | Count Triplets |
| `_04_frequency_queries` | Frequency Queries |
| `_05_anagrams` | Anagrams |

### `graphs`

İki tür içerik barındırır: HackerRank problemleri ve graf veri yapısı örnekleri.

**Problemler**

| Paket | Problem |
|---|---|
| `_00_roads_and_libraries` | Roads and Libraries |
| `_01_shortest_reach_in_a_graph` | Shortest Reach in a Graph |
| `_02_dfs_connected_cell_in_a_grid` | DFS: Connected Cell in a Grid |

**Veri yapısı örnekleri** — problem çözümü değil, graf temsillerini ve gezinme algoritmalarını çalışmak için yazılmış küçük örnekler.

| Paket | Konu |
|---|---|
| `graph_00_bfs` | BFS (üç farklı uygulama) |
| `graph_01_adjacency_matrix` | Komşuluk matrisi |
| `graph_02_dfs` | DFS |
| `graph_03_adjacency_list` | Komşuluk listesi |
| `graph_04_dijkstra_01`, `graph_04_dijkstra_02` | Dijkstra en kısa yol |
| `graph_05_weighted_graph_01` | Ağırlıklı graf |

### `dynamic_programming`

| Paket | Problem |
|---|---|
| `_01_maxarraysum` | Max Array Sum |
| `_04_candies` | Candies |

### `greedy_algorithms`

| Paket | Problem |
|---|---|
| `_01_min_absolute_diff` | Minimum Absolute Difference in an Array |
| `_02_luck_balance` | Luck Balance |
| `_03_greedy_florist` | Greedy Florist (iki çözüm: sıralama ve öncelik kuyruğu) |
| `_04_max_min` | Max Min |

## Çalışma notları

Bazı problemlerin yanında Markdown dosyaları bulunur:

- **Problem tanımı** (`non-divisible_subset.md`, `3-sum-closest.md`) — HackerRank/LeetCode'daki problem metni, kısıtlar ve örnekler.
- **`key-takeaways.md`** — çözümün arkasındaki düşünce: hangi gözlem problemi çözdü, hangi yaklaşımlar denendi, karmaşıklık nereden geliyor, hangi testler eksik kaldı.

Şu an notu olan problemler: `algorithms/_01`, `algorithms/_03`, `warm_challenges/_00`, `_01`, `_02`.

## Proje yapısı

```
src/
  main/java/com/cihangir/
    MainApp.java
    algorithms/                  <- konu paketi
      _03/                       <- problem paketi
        Solution01.java
        non-divisible_subset.md
        key-takeaways.md
        testdata/
          input04.txt
    warm_challenges/
    dictionaries_and_hashmaps/
    graphs/
    dynamic_programming/
    greedy_algorithms/
  test/java/com/cihangir/
    dictionaries_and_hashmaps/   <- JUnit testleri
run.sh
pom.xml
```

## Test verisi formatı

`algorithms` paketindeki test dosyaları birden fazla senaryo içerebilir. Her senaryo üç bölümden oluşur ve `---` ile ayrılır:

```
7 5              <- n ve k
1 6 2 7 3 5 10   <- girdi
---
5                <- beklenen sonuç
```

Diğer paketlerde test dosyaları HackerRank'in ham girdi formatını korur.
