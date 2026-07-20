# Non-Divisible Subset — Sade Anlatım

## Problem ne istiyor?

Elimizde bir sayı listesi ve `k` değeri var.

Bu listeden mümkün olduğunca fazla sayı seçmek istiyoruz. Ancak seçtiğimiz herhangi iki sayının toplamı `k`'ya tam bölünmemeli.

Örneğin `k = 5` ise:

- `2 + 3 = 5` olduğu için `2` ve `3` birlikte seçilemez.
- `2 + 7 = 9` olduğu için `2` ve `7` birlikte seçilebilir.

Amaç, bu kurala uyan en büyük alt kümenin eleman sayısını bulmaktır.

## Ana fikir: Sayıları kalanlarına göre grupla

İki sayının toplamının `k`'ya bölünüp bölünmediğini anlamak için sayıların tamamına bakmamıza gerek yoktur. `k` ile bölümden kalanlarına bakmak yeterlidir.

```text
(a + b) % k = ((a % k) + (b % k)) % k
```

Örneğin `k = 5` için:

```text
1 % 5 = 1
6 % 5 = 1
11 % 5 = 1
```

Bu üç sayı aynı şekilde davranır. Bu yüzden kod, sayıları kalan değerini anahtar olarak kullanarak gruplar:

```java
groupsByRemainder
    .computeIfAbsent(value % k, remainder -> new ArrayList<>())
    .add(value);
```

## `input04.txt` verisi

```text
7 5
1 6 2 7 3 5 10
---
5
```

Burada:

- `7`, listedeki sayı adedidir.
- `5`, bölen olarak kullanılacak `k` değeridir.
- İkinci satır, işlenecek sayıları içerir.
- Son satırdaki `5`, beklenen sonuçtur.

Sayıları `5` ile bölümden kalanlarına göre gruplayalım:

| Kalan | Sayılar |
|------:|---------|
| 0 | `[5, 10]` |
| 1 | `[1, 6]` |
| 2 | `[2, 7]` |
| 3 | `[3]` |
| 4 | `[]` |

## Hangi gruplar birlikte seçilemez?

Kalanların toplamı `5` olduğunda sayıların toplamı da `5`'e tam bölünür.

Bu nedenle:

- Kalanı `1` olan sayılar ile kalanı `4` olan sayılar birlikte seçilemez.
- Kalanı `2` olan sayılar ile kalanı `3` olan sayılar birlikte seçilemez.

Kod, bir kalanla birlikte kullanılamayacak diğer kalanı şöyle hesaplar:

```java
int opposite = (k - remainder) % k;
```

Buradaki `opposite`, birlikte seçildiğinde toplamı `k`'ya bölünebilir hâle getiren diğer kalan grubudur.

## `input04.txt` için seçimler

### 1. Kalanı `0` olan grup

```text
[5, 10]
```

Bu gruptan yalnızca bir sayı alabiliriz. Çünkü:

```text
5 + 10 = 15
15 % 5 = 0
```

Kod ilk sayı olan `5`'i seçer. `10` seçilseydi de sonuç değişmezdi.

### 2. Kalanı `1` ve `4` olan gruplar

```text
kalan 1 -> [1, 6]
kalan 4 -> []
```

Bu iki gruptan yalnızca biri kullanılabilir. Daha fazla sayı alabilmek için `[1, 6]` seçilir.

### 3. Kalanı `2` ve `3` olan gruplar

```text
kalan 2 -> [2, 7]
kalan 3 -> [3]
```

İki grubu birlikte kullanamayız. Örneğin:

```text
2 + 3 = 5
7 + 3 = 10
```

Her iki toplam da `5`'e tam bölünür. Bu yüzden daha fazla elemanı olan `[2, 7]` grubu seçilir.

## Sonuç nasıl oluşuyor?

Seçilen sayılar şunlardır:

```text
[5, 1, 6, 2, 7]
```

Toplam eleman sayısı:

```text
1 + 2 + 2 = 5
```

Fonksiyon bu nedenle `5` döndürür.

## Kodun seçim mantığı

Birlikte kullanılamayan iki gruptan eleman sayısı fazla olan seçilir:

```java
boolean pickGroup = group.size() >= oppositeGroup.size();
selected.addAll(pickGroup ? group : oppositeGroup);
```

Her grup çifti yalnızca bir kez işlenmelidir. Örneğin `1 ve 4` değerlendirildikten sonra `4 ve 1` için aynı işlemi tekrar yapmaya gerek yoktur:

```java
if (remainder > opposite) {
    continue;
}
```

## Dikkat edilmesi gereken iki durum

### Kalan `0`

Kalanı `0` olan iki sayının toplamı her zaman `k`'ya bölünür. Bu nedenle bu gruptan en fazla bir sayı seçilir.

### `k` çift olduğunda kalan `k / 2`

Örneğin `k = 6` ise kalanı `3` olan iki sayının toplamı `6`'ya bölünür:

```text
3 + 9 = 12
12 % 6 = 0
```

Bu gruptan da en fazla bir sayı seçilebilir.

Kod iki durumu aynı koşulla yönetir:

```java
if (remainder == opposite) {
    if (!group.isEmpty()) {
        selected.add(group.get(0));
    }
    continue;
}
```

## Performans

- Sayıları gruplamak: `O(n)`
- Kalan gruplarını değerlendirmek: `O(k)`
- Toplam çalışma süresi: `O(n + k)`

Mevcut kod, seçilen sayıları debug çıktısında göstermek için listelerde saklar. Yalnızca sonuç isteniyorsa her kalan grubunun eleman sayısını tutan `int[k]` dizisi de yeterlidir. Bu durumda bellek kullanımı `O(k)` olur.

## Kısa özet

Algoritmanın yaptığı iş şudur:

1. Sayıları `k` ile bölümden kalanlarına göre gruplar.
2. Birlikte seçildiğinde toplamı `k`'ya bölünen grupları eşleştirir.
3. Her eşleşmede daha fazla elemanı olan grubu seçer.
4. Kalanı `0` olan gruptan en fazla bir sayı alır.
5. `k` çiftse kalanı `k / 2` olan gruptan da en fazla bir sayı alır.

Temel düşünce: **Tek tek sayıları karşılaştırmak yerine, aynı davranışı gösteren sayıları kalanlarına göre gruplamak.**
