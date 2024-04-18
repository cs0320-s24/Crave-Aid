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

//////////////////////////////// MOCKED DATA /////////////////////////////////

/**
 * Tests big combo of interaction with mocked backend.
 */
test("test big combo of interaction, mocked", async ({ page }) => {
  await page.goto("http://localhost:8000/");
  await expect(page.locator("h2")).toContainText(
    "Interactive Map and REPL Console"
  );
  await expect(page.locator("h5")).toContainText(SPOOF_UID);
  await expect(page.getByRole("button", { name: "Sign Out" })).toBeVisible();
  await expect(page.getByLabel("Map", { exact: true })).toBeVisible();
  await expect(
    page.getByLabel("REPL and Search capability container")
  ).toBeVisible();

  // set pins and reload
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeHidden();
  await page.getByLabel("Map", { exact: true }).click({
    position: {
      x: 499,
      y: 186,
    },
  });
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeVisible();
  await page.reload();
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeVisible();

  // clear pins
  await page.getByRole("button", { name: "Clear All Pins" }).click();
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeHidden();

  await page.reload();
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeHidden();

  // set more pins and reload
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeHidden();
  await page.getByLabel("Map", { exact: true }).click({
    position: {
      x: 499,
      y: 186,
    },
  });
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeVisible();
  await page.reload();
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeVisible();

  // search keyword with no results
  await page.getByLabel("Command Input Field").fill("search gibberish");
  await page.getByLabel("Submit Command Button").click();
  var URLToIntercept = `http://localhost:3232/redliningSearch?keyword=gibberish`;
  await page.route(URLToIntercept, async (route) => {
    console.log("Intercepted request:", route.request().url());
    route.fulfill({
      status: 200,
      contentType: "application/json",
      body: {
        features: [],
        type: "FeatureCollection",
      },
    });
  });
  page.getByText(`Searching for: "gibberish": results overlayed in purple`);

  // search keyword with results
  await page.getByLabel("Command Input Field").fill("search bus");
  await page.getByLabel("Submit Command Button").click();
  var URLToIntercept = `http://localhost:3232/redliningSearch?keyword=bus`;
  await page.route(URLToIntercept, async (route) => {
    console.log("Intercepted request:", route.request().url());
    route.fulfill({
      status: 200,
      contentType: "application/json",
      body: {
        features: [
          {
            geometry: {
              coordinates: [
                [
                  [
                    [-86.761343, 33.512401],
                    [-86.758669, 33.509329],
                  ],
                ],
              ],
              type: "MultiPolygon",
            },
            properties: {
              area_description_data: {
                "5": "Both sales and rental prices in 1929 were off about 20% from 1926-28 peak. Location of property within this area will justify policy of holding for its value.",
                "6": "Redmont Park, Rockridge Park, Warwick Manor, and southern portion of Milner Heights A 2",
                "31": "83",
                "32": "8",
                "33": "4",
                "3n": "1936 No rentals 55 No rentals N/A 50-100 N/A",
                "3j": "N/A 10000-30000 61 10000-27500 1938 No sales N/A",
                "3g": "None None 18 (1000-3000)",
                "1d": "65%",
              },
              city: "Birmingham",
              holc_grade: "A",
              holc_id: "A2",
              name: "Redmont Park, Rockridge Park, Warwick Manor, and southern portion of Milner Heights",
              neighborhood_id: 193.0,
              state: "AL",
            },
            type: "Feature",
          },
        ],
        type: "FeatureCollection",
      },
    });
  });
  page.getByText(`Searching for: "bus": results overlayed in purple`);

  // clear results
  await page.getByPlaceholder("Enter command here!").click();
  await page.getByPlaceholder("Enter command here!").fill("reset");
  await page.getByLabel("Submit Command Button").click();
  await expect(
    page.getByText("Successfully cleared search results")
  ).toBeVisible();

  await page.getByLabel("Command Input Field").fill("search manatee");
  await page.getByLabel("Submit Command Button").click();
  var URLToIntercept = `http://localhost:3232/redliningSearch?keyword=bus`;
  await page.route(URLToIntercept, async (route) => {
    console.log("Intercepted request:", route.request().url());
    route.fulfill({
      status: 200,
      contentType: "application/json",
      body: {
        features: [
          {
            geometry: {
              coordinates: [
                [
                  [
                    [-86.761343, 33.512401],
                    [-86.758669, 33.509329],
                  ],
                ],
              ],
              type: "MultiPolygon",
            },
            properties: {
              area_description_data: {
                "5": "Both sales and rental prices in 1929 were off about 20% from 1926-28 peak. Location of property within this area will justify policy of holding for its value.",
                "6": "Redmont Park, Rockridge Park, Warwick Manor, and southern portion of Milner Heights A 2",
                "31": "83",
                "32": "8",
                "33": "4",
                "3n": "1936 No rentals 55 No rentals N/A 50-100 N/A",
                "3j": "N/A 10000-30000 61 10000-27500 1938 No sales N/A",
                "3g": "None None 18 (1000-3000)",
                "1d": "65%",
              },
              city: "Birmingham",
              holc_grade: "A",
              holc_id: "A2",
              name: "Redmont Park, Rockridge Park, Warwick Manor, and southern portion of Milner Heights",
              neighborhood_id: 193.0,
              state: "AL",
            },
            type: "Feature",
          },
        ],
        type: "FeatureCollection",
      },
    });
  });
  page.getByText(`Searching for: "manatee": results overlayed in purple`);

  // search keyword command without keyword
  await page.getByPlaceholder("Enter command here!").click();
  await page.getByPlaceholder("Enter command here!").fill("search ");
  await page.getByLabel("Submit Command Button").click();
  var URLToIntercept = `http://localhost:3232/redliningSearch?keyword=gibberish`;
  await page.route(URLToIntercept, async (route) => {
    console.log("Intercepted request:", route.request().url());
    route.fulfill({
      status: 200,
      contentType: "application/json",
      body: {
        features: [],
        type: "FeatureCollection",
      },
    });
  });
  await expect(page.getByText("Please provide a keyword")).toBeVisible();

  // clear results
  await page.getByPlaceholder("Enter command here!").click();
  await page.getByPlaceholder("Enter command here!").fill("reset");
  await page.getByLabel("Submit Command Button").click();
  await expect(
    page.getByText("Successfully cleared search results")
  ).toBeVisible();
});

//////////////////////////////// REAL DATA /////////////////////////////////

/**
 * Tests big combo of interaction with real backend.
 */
test("test big combo of interaction, real", async ({ page }) => {
  await page.goto("http://localhost:8000/");
  await expect(page.locator("h2")).toContainText(
    "Interactive Map and REPL Console"
  );
  await expect(page.locator("h5")).toContainText(SPOOF_UID);
  await expect(page.getByRole("button", { name: "Sign Out" })).toBeVisible();
  await expect(page.getByLabel("Map", { exact: true })).toBeVisible();
  await expect(
    page.getByLabel("REPL and Search capability container")
  ).toBeVisible();

  // set pins and reload
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeHidden();
  await page.getByLabel("Map", { exact: true }).click({
    position: {
      x: 499,
      y: 186,
    },
  });
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeVisible();
  await page.reload();
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeVisible();

  // clear pins
  await page.getByRole("button", { name: "Clear All Pins" }).click();
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeHidden();

  await page.reload();
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeHidden();

  // set more pins and reload
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeHidden();
  await page.getByLabel("Map", { exact: true }).click({
    position: {
      x: 499,
      y: 186,
    },
  });
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeVisible();
  await page.reload();
  await expect(
    page.getByLabel("Map marker").locator("div").first()
  ).toBeVisible();

  // search keyword no results
  await page.getByLabel("Command Input Field").fill("search gibberish");
  await page.getByLabel("Submit Command Button").click();
  page.getByText(`Searching for: "gibberish": results overlayed in purple`);
  // search keyword with results
  await page.getByLabel("Command Input Field").fill("search bus");
  await page.getByLabel("Submit Command Button").click();
  page.getByText(`Searching for: "bus": results overlayed in purple`);

  // clear results
  await page.getByPlaceholder("Enter command here!").click();
  await page.getByPlaceholder("Enter command here!").fill("reset");
  await page.getByLabel("Submit Command Button").click();
  await expect(
    page.getByText("Successfully cleared search results")
  ).toBeVisible();

  // search without providing a keyword
  await page.getByPlaceholder("Enter command here!").click();
  await page.getByPlaceholder("Enter command here!").fill("search ");
  await page.getByLabel("Submit Command Button").click();
  await expect(page.getByText("Please provide a keyword")).toBeVisible();

  // search keyword with results
  await page.getByLabel("Command Input Field").fill("search man");
  await page.getByLabel("Submit Command Button").click();
  page.getByText(`Searching for: "man": results overlayed in purple`);
});