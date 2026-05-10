package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CatCafeTest {

  @Test
  void givenEmptyCafe_whenGetCatCount_thenReturnsZero() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    long count = cafe.getCatCount();

    // then
    assertEquals(0, count);
  }

  @Test
  void givenOneCat_whenGetCatCount_thenReturnsOne() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Morticia", 3));

    // when
    long count = cafe.getCatCount();

    // then
    assertEquals(1, count);
  }

  @Test
  void givenMultipleCats_whenGetCatCount_thenReturnsNumberOfAddedCats() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Morticia", 3));
    cafe.addCat(new FelineOverLord("Gwenapurr", 4));
    cafe.addCat(new FelineOverLord("Fitzby", 5));

    // when
    long count = cafe.getCatCount();

    // then
    assertEquals(3, count);
  }

  @Test
  void givenNullCat_whenAddCat_thenThrowsNullPointerException() {
    // given
    CatCafe cafe = new CatCafe();

    // when / then
    assertThrows(NullPointerException.class, () -> cafe.addCat(null));
  }

  @Test
  void givenExistingCatName_whenGetCatByName_thenReturnsThatCat() {
    // given
    CatCafe cafe = new CatCafe();
    FelineOverLord cat = new FelineOverLord("Morticia", 3);
    cafe.addCat(cat);

    // when
    FelineOverLord found = cafe.getCatByName("Morticia");

    // then
    assertSame(cat, found);
  }

  @Test
  void givenMissingCatName_whenGetCatByName_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Morticia", 3));

    // when
    FelineOverLord found = cafe.getCatByName("Unknown");

    // then
    assertNull(found);
  }

  @Test
  void givenNullName_whenGetCatByName_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Morticia", 3));

    // when
    FelineOverLord found = cafe.getCatByName(null);

    // then
    assertNull(found);
  }

  @Test
  void givenCatInWeightRange_whenGetCatByWeight_thenReturnsCat() {
    // given
    CatCafe cafe = new CatCafe();
    FelineOverLord cat = new FelineOverLord("Morticia", 3);
    cafe.addCat(cat);

    // when
    FelineOverLord found = cafe.getCatByWeight(3, 4);

    // then
    assertSame(cat, found);
  }

  @Test
  void givenCatAtLowerWeightLimit_whenGetCatByWeight_thenReturnsCat() {
    // given
    CatCafe cafe = new CatCafe();
    FelineOverLord cat = new FelineOverLord("LowerLimitCat", 3);
    cafe.addCat(cat);

    // when
    FelineOverLord found = cafe.getCatByWeight(3, 5);

    // then
    assertSame(cat, found);
  }

  @Test
  void givenCatAtUpperWeightLimit_whenGetCatByWeight_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("UpperLimitCat", 5));

    // when
    FelineOverLord found = cafe.getCatByWeight(3, 5);

    // then
    assertNull(found);
  }

  @Test
  void givenNegativeMinimumWeight_whenGetCatByWeight_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Morticia", 3));

    // when
    FelineOverLord found = cafe.getCatByWeight(-1, 4);

    // then
    assertNull(found);
  }

  @Test
  void givenMaximumWeightSmallerThanMinimum_whenGetCatByWeight_thenReturnsNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Morticia", 3));

    // when
    FelineOverLord found = cafe.getCatByWeight(5, 3);

    // then
    assertNull(found);
  }
}
