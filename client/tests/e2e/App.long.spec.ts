// import { expect, test } from "@playwright/test";
// import { clearUser } from "../../src/utils/api";

// /**
//   The general shapes of tests in Playwright Test are:
//     1. Navigate to a URL
//     2. Interact with the page
//     3. Assert something about the page against your expectations
//   Look for this pattern in the tests below!
//  */

// const SPOOF_UID = "mock-user-id";

// test.beforeEach(
//   "add spoof uid cookie to browser",
//   async ({ context, page }) => {
//     // - Add "uid" cookie to the browser context
//     await context.addCookies([
//       {
//         name: "uid",
//         value: SPOOF_UID,
//         url: "http://localhost:8000",
//       },
//     ]);

//     // wipe everything for this spoofed UID in the database.
//     await clearUser(SPOOF_UID);
//   }
// );

// test("test-initial-load-visibility", async ({ page }) => {
//   await page.goto("http://localhost:8000/");
//   await expect(page.getByRole("button", { name: "My Pantry" })).toBeVisible();
//   await expect(page.getByRole("button", { name: "Recipes" })).toBeVisible();
//   await expect(
//     page.getByPlaceholder("Search ingredients to add to")
//   ).toBeVisible();
//   await expect(page.getByLabel("Gearup Title")).toBeVisible();
//   await expect(page.getByRole("button", { name: "Sign Out" })).toBeVisible();
// });

// test("test-pantry-page-visibility", async ({ page }) => {
//   await page.goto("http://localhost:8000/");
//   await page.getByRole("button", { name: "Recipes" }).click();
//   await expect(
//     page.getByPlaceholder("Search a recipe by ingredients")
//   ).toBeVisible();
//   await expect(page.getByRole("button").nth(3)).toBeVisible();
//   await expect(page.getByLabel("Gearup Title")).toBeVisible();
//   await expect(page.getByRole("button", { name: "My Pantry" })).toBeVisible();
//   await expect(page.getByRole("button", { name: "Sign Out" })).toBeVisible();
// });

