import { expect, test } from "@playwright/test";
import { clearUser } from "../../src/utils/api";

/**
  The general shapes of tests in Playwright Test are:
    1. Navigate to a URL
    2. Interact with the page
    3. Assert something about the page against your expectations
  Look for this pattern in the tests below!
 */

const SPOOF_UID = "mock-user-id";

test.beforeEach(
  "add spoof uid cookie to browser",
  async ({ context, page }) => {
    // - Add "uid" cookie to the browser context
    await context.addCookies([
      {
        name: "uid",
        value: SPOOF_UID,
        url: "http://localhost:8000",
      },
    ]);

    // wipe everything for this spoofed UID in the database.
    await clearUser(SPOOF_UID);
  }
);

test("test-initial-load-visibility", async ({ page }) => {
  await page.goto("http://localhost:8000/");
  await expect(page.getByRole("button", { name: "My Pantry" })).toBeVisible();
  await expect(page.getByRole("button", { name: "Recipes" })).toBeVisible();
  await expect(
    page.getByPlaceholder("Search ingredients to add to")
  ).toBeVisible();
  await expect(page.getByLabel("Gearup Title")).toBeVisible();
  await expect(page.getByRole("button", { name: "Sign Out" })).toBeVisible();
});

test("test-pantry-page-visibility", async ({ page }) => {
  await page.goto("http://localhost:8000/");
  await page.getByRole("button", { name: "Recipes" }).click();
  await expect(
    page.getByPlaceholder("Search a recipe by ingredients")
  ).toBeVisible();
  await expect(page.getByRole("button").nth(3)).toBeVisible();
  await expect(page.getByLabel("Gearup Title")).toBeVisible();
  await expect(page.getByRole("button", { name: "My Pantry" })).toBeVisible();
  await expect(page.getByRole("button", { name: "Sign Out" })).toBeVisible();
});

test("test-proper-ingredient-options-on-search", async ({ page }) => {
  await page.goto("http://localhost:8000/");
  await page.getByPlaceholder("Search ingredients to add to").click();
  await page.getByPlaceholder("Search ingredients to add to").fill("salmon");
  await expect(
    page.locator("li").filter({ hasText: /^Salmon$/ })
  ).toBeVisible();
  await expect(
    page.locator("li").filter({ hasText: "Smoked Salmon" })
  ).toBeVisible();
  await expect(
    page
      .locator("li")
      .filter({ hasText: /^Salmon$/ })
      .locator("i")
  ).toBeVisible();
});

test("test-single-ingredient-pantry-addition", async ({ page }) => {
  await page.goto("http://localhost:8000/");
  await page.getByPlaceholder("Search ingredients to add to").click();
  await page.getByPlaceholder("Search ingredients to add to").fill("sa");
  await page.getByText("Salmon", { exact: true }).click();
  await expect(page.getByText("Salmon")).toBeVisible();
});
test("test-multi-ingredient-pantry-addition", async ({ page }) => {
  await page.goto("http://localhost:8000/");
  await page.getByPlaceholder("Search ingredients to add to").click();
  await page.getByPlaceholder("Search ingredients to add to").fill("sa");
  await page.getByText("Salmon", { exact: true }).click();
  await page.getByPlaceholder("Search ingredients to add to").click();
  await page.getByPlaceholder("Search ingredients to add to").fill("sa");
  await page.getByText("Balsamic Vinegar").click();
  await page.getByPlaceholder("Search ingredients to add to").click();
  await page.getByPlaceholder("Search ingredients to add to").fill("we");
  await page.getByText("Sunflower Oil").click();
  await page.getByPlaceholder("Search ingredients to add to").click();
  await page.getByPlaceholder("Search ingredients to add to").fill("tr");
  await page.getByText("Black Treacle").click();
  await expect(page.getByRole("cell", { name: "Salmon" })).toBeVisible();
  await expect(page.getByRole("cell", { name: "Sunflower Oil" })).toBeVisible();
  await expect(
    page.getByRole("cell", { name: "Balsamic Vinegar" })
  ).toBeVisible();
  await expect(page.getByRole("cell", { name: "Black Treacle" })).toBeVisible();
});

test("test-single-ingredient-pantry-addition-and-removal", async ({ page }) => {
  await page.goto("http://localhost:8000/");
  await page.getByPlaceholder("Search ingredients to add to").click();
  await page.getByPlaceholder("Search ingredients to add to").fill("sa");
  await page.getByText("Salmon", { exact: true }).click();
  await expect(page.getByRole("cell", { name: "Salmon" })).toBeVisible();
  await page.getByRole('cell', { name: 'Salmon' }).click();
  await expect(page.getByRole("cell", { name: "Salmon" })).toBeHidden();
});

test("test-multi-ingredient-pantry-addition-and-removal", async ({ page }) => {
  await page.goto("http://localhost:8000/");
  await page.getByPlaceholder("Search ingredients to add to").click();
  await page.getByPlaceholder("Search ingredients to add to").fill("sa");
  await page.getByText("Salmon", { exact: true }).click();
  await page.getByPlaceholder("Search ingredients to add to").click();
  await page.getByPlaceholder("Search ingredients to add to").fill("a");
  await page.getByText("Avocado", { exact: true }).click();
  await page.getByPlaceholder("Search ingredients to add to").click();
  await page.getByPlaceholder("Search ingredients to add to").fill("sa");
  await page.getByText("Salmon", { exact: true }).click();
  await page.getByPlaceholder("Search ingredients to add to").click();
  await page.getByPlaceholder("Search ingredients to add to").fill("sa");
  await page.getByText("Balsamic Vinegar").click();
  await expect(page.getByRole("cell", { name: "Salmon" })).toBeVisible();
  await expect(
    page.getByRole("cell", { name: "Balsamic Vinegar" })
  ).toBeVisible();
  await expect(
    page.getByRole("cell", { name: "Avocado" })
  ).toBeVisible();
  await page.getByRole("cell", { name: "Salmon" }).click();
  await page.getByRole("cell", { name: "Avocado" }).click();
  await page.getByRole("cell", { name: "Balsamic Vinegar" }).click();
  await expect(page.getByRole("cell", { name: "Salmon" })).toBeHidden();
  await expect(
    page.getByRole("cell", { name: "Balsamic Vinegar" })
  ).toBeHidden();
  await expect(page.getByRole("cell", { name: "Avocado" })).toBeHidden();
});

test("test-single-ingredient-recipe-addition", async ({ page }) => {
  await page.goto("http://localhost:8000/");
  await page.getByPlaceholder("Search ingredients to add to").click();
  await page.getByPlaceholder("Search ingredients to add to").fill("sa");
  await page.getByText("Salmon", { exact: true }).click();
  await expect(page.getByRole("cell", { name: "Salmon" })).toBeVisible();
});

test("test-single-ingredient-recipe-addition-and-removal", async ({ page }) => {
  await page.goto("http://localhost:8000/");
  await page.getByRole("button", { name: "Recipes" }).click();
  await page.getByPlaceholder("Search a recipe by ingredients").click();
  await page.getByPlaceholder("Search a recipe by ingredients").fill("sa");
  await page.getByText("Salmon", { exact: true }).click();
  await expect(page.getByRole("cell", { name: "Salmon" })).toBeVisible();
  await page.getByRole('cell', { name: 'Salmon' }).click();
  await expect(page.getByRole("cell", { name: "Salmon" })).toBeHidden();
});

test("test-recipe-page-multi-add-remove", async ({ page }) => {
  await page.goto("http://localhost:8000/");
  await expect(page.getByRole("button", { name: "Recipes" })).toBeVisible();
  await page.getByRole("button", { name: "Recipes" }).click();
  await page.getByPlaceholder("Search a recipe by ingredients").click();
  await page.getByPlaceholder("Search a recipe by ingredients").fill("sa");
  await page
    .locator("li")
    .filter({ hasText: /^Salmon$/ })
    .click();
  await page.getByPlaceholder("Search a recipe by ingredients").click();
  await page.getByPlaceholder("Search a recipe by ingredients").fill("re");
  await page.getByText("Black Treacle").click();
  await page.getByPlaceholder("Search a recipe by ingredients").click();
  await page.getByPlaceholder("Search a recipe by ingredients").fill("c");
  await page.getByText("Chicken", { exact: true }).click();
  await expect(page.getByRole("cell", { name: "Salmon" })).toBeVisible();
  await expect(page.getByRole("cell", { name: "Black Treacle" })).toBeVisible();
  await expect(page.getByRole("cell", { name: "Chicken" })).toBeVisible();
  await page.getByRole("cell", { name: "Chicken" }).click();
  await page.getByRole("cell", { name: "Black Treacle" }).click();
  await page.getByRole("cell", { name: "Salmon" }).click();
  await expect(page.getByRole("cell", { name: "Salmon" })).toBeHidden();
  await expect(page.getByRole("cell", { name: "Black Treacle" })).toBeHidden();
  await expect(page.getByRole("cell", { name: "Chicken" })).toBeHidden();
});

test("test-recipe-page-searching", async ({ page }) => {
  await page.goto("http://localhost:8000/");
  await page.getByRole("button", { name: "Recipes" }).click();
  await page.getByPlaceholder("Search a recipe by ingredients").click();
  await page.getByPlaceholder("Search a recipe by ingredients").fill("sal");
  await page.getByText("Salmon", { exact: true }).click();
  await expect(page.getByRole("cell", { name: "Salmon" })).toBeVisible();
  await page.getByPlaceholder("Search a recipe by ingredients").click();
  await page.getByPlaceholder("Search a recipe by ingredients").fill("we");
  await page.getByText("Sweetcorn").click();
  await expect(page.getByRole("cell", { name: "Sweetcorn" })).toBeVisible();
  await page.getByRole("button").nth(3).click();
  await expect(page.getByRole("cell", { name: "Salmon" })).toBeVisible();
  await expect(page.getByRole("cell", { name: "Sweetcorn" })).toBeVisible();
  await expect(page.getByText("recipes found.")).toBeVisible();
});