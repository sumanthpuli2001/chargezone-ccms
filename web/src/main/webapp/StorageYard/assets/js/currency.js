
(function (global) {
  "use strict";

  var CURRENCIES = {
    INR: ["₹", "Indian Rupee", "en-IN"],
    USD: ["$", "US Dollar", "en-US"],
    EUR: ["€", "Euro", "de-DE"],
    GBP: ["£", "British Pound", "en-GB"],
    JPY: ["¥", "Japanese Yen", "ja-JP"],
    CNY: ["¥", "Chinese Yuan", "zh-CN"],
    AED: ["د.إ", "UAE Dirham", "en-AE"],
    SAR: ["﷼", "Saudi Riyal", "en-SA"],
    QAR: ["ر.ق", "Qatari Riyal", "en-US"],
    KWD: ["د.ك", "Kuwaiti Dinar", "en-US"],
    BHD: [".د.ب", "Bahraini Dinar", "en-US"],
    OMR: ["ر.ع.", "Omani Rial", "en-US"],
    AUD: ["A$", "Australian Dollar", "en-AU"],
    CAD: ["C$", "Canadian Dollar", "en-CA"],
    NZD: ["NZ$", "New Zealand Dollar", "en-NZ"],
    SGD: ["S$", "Singapore Dollar", "en-SG"],
    HKD: ["HK$", "Hong Kong Dollar", "en-HK"],
    CHF: ["CHF", "Swiss Franc", "de-CH"],
    SEK: ["kr", "Swedish Krona", "sv-SE"],
    NOK: ["kr", "Norwegian Krone", "nb-NO"],
    DKK: ["kr", "Danish Krone", "da-DK"],
    PLN: ["zł", "Polish Zloty", "pl-PL"],
    CZK: ["Kč", "Czech Koruna", "cs-CZ"],
    HUF: ["Ft", "Hungarian Forint", "hu-HU"],
    RON: ["lei", "Romanian Leu", "ro-RO"],
    BGN: ["лв", "Bulgarian Lev", "bg-BG"], // legacy: Bulgaria uses EUR from 2026
    RUB: ["₽", "Russian Ruble", "ru-RU"],
    UAH: ["₴", "Ukrainian Hryvnia", "uk-UA"],
    TRY: ["₺", "Turkish Lira", "tr-TR"],
    ILS: ["₪", "Israeli New Shekel", "he-IL"],
    EGP: ["E£", "Egyptian Pound", "en-EG"],
    ZAR: ["R", "South African Rand", "en-ZA"],
    NGN: ["₦", "Nigerian Naira", "en-NG"],
    KES: ["KSh", "Kenyan Shilling", "en-KE"],
    GHS: ["GH₵", "Ghanaian Cedi", "en-GH"],
    MAD: ["MAD", "Moroccan Dirham", "en-US"],
    ZWG: ["ZiG", "Zimbabwe Gold", "en-US"],
    PKR: ["₨", "Pakistani Rupee", "en-PK"],
    BDT: ["৳", "Bangladeshi Taka", "en-BD"],
    LKR: ["Rs", "Sri Lankan Rupee", "en-LK"],
    NPR: ["रू", "Nepalese Rupee", "en-NP"],
    AFN: ["؋", "Afghan Afghani", "en-US"],
    THB: ["฿", "Thai Baht", "th-TH"],
    VND: ["₫", "Vietnamese Dong", "vi-VN"],
    IDR: ["Rp", "Indonesian Rupiah", "id-ID"],
    MYR: ["RM", "Malaysian Ringgit", "ms-MY"],
    PHP: ["₱", "Philippine Peso", "en-PH"],
    KRW: ["₩", "South Korean Won", "ko-KR"],
    TWD: ["NT$", "New Taiwan Dollar", "zh-TW"],
    KZT: ["₸", "Kazakhstani Tenge", "kk-KZ"],
    MXN: ["Mex$", "Mexican Peso", "es-MX"],
    BRL: ["R$", "Brazilian Real", "pt-BR"],
    ARS: ["AR$", "Argentine Peso", "es-AR"],
    CLP: ["CLP$", "Chilean Peso", "es-CL"],
    COP: ["COL$", "Colombian Peso", "es-CO"],
    PEN: ["S/", "Peruvian Sol", "es-PE"],
    UYU: ["$U", "Uruguayan Peso", "es-UY"],
    VES: ["Bs.S", "Venezuelan Bolivar", "es-VE"],
    JMD: ["J$", "Jamaican Dollar", "en-JM"],
    ISK: ["kr", "Icelandic Krona", "is-IS"],
    BTC: ["₿", "Bitcoin", "en-US"],
    AMD: ["֏", "Armenian Dram", "en-US"],
    AZN: ["₼", "Azerbaijani Manat", "en-US"],
    GEL: ["₾", "Georgian Lari", "en-US"],
    BYN: ["Br", "Belarusian Ruble", "en-US"],
    MDL: ["L", "Moldovan Leu", "en-US"],
    RSD: ["дин.", "Serbian Dinar", "en-US"],
    ALL: ["L", "Albanian Lek", "en-US"],
    MKD: ["ден", "Macedonian Denar", "en-US"],
    BAM: ["KM", "Bosnia-Herzegovina Mark", "en-US"],
    LBP: ["ل.ل", "Lebanese Pound", "en-US"],
    JOD: ["د.ا", "Jordanian Dinar", "en-US"],
    IQD: ["ع.د", "Iraqi Dinar", "en-US"],
    IRR: ["﷼", "Iranian Rial", "en-US"],
    SYP: ["£S", "Syrian Pound", "en-US"],
    YER: ["﷼", "Yemeni Rial", "en-US"],
    LYD: ["ل.د", "Libyan Dinar", "en-US"],
    TND: ["د.ت", "Tunisian Dinar", "en-US"],
    DZD: ["د.ج", "Algerian Dinar", "en-US"],
    ETB: ["Br", "Ethiopian Birr", "en-US"],
    UGX: ["USh", "Ugandan Shilling", "en-US"],
    TZS: ["TSh", "Tanzanian Shilling", "en-US"],
    RWF: ["FRw", "Rwandan Franc", "en-US"],
    XOF: ["CFA", "West African CFA Franc", "en-US"],
    XAF: ["FCFA", "Central African CFA Franc", "en-US"],
    MUR: ["₨", "Mauritian Rupee", "en-US"],
    BWP: ["P", "Botswana Pula", "en-US"],
    NAD: ["N$", "Namibian Dollar", "en-US"],
    ZMW: ["ZK", "Zambian Kwacha", "en-US"],
    MZN: ["MT", "Mozambican Metical", "en-US"],
    AOA: ["Kz", "Angolan Kwanza", "en-US"],
    SDG: ["ج.س.", "Sudanese Pound", "en-US"],
    MMK: ["K", "Myanmar Kyat", "en-US"],
    KHR: ["៛", "Cambodian Riel", "en-US"],
    LAK: ["₭", "Lao Kip", "en-US"],
    MNT: ["₮", "Mongolian Tugrik", "en-US"],
    BND: ["B$", "Brunei Dollar", "en-US"],
    MVR: ["Rf", "Maldivian Rufiyaa", "en-US"],
    BTN: ["Nu.", "Bhutanese Ngultrum", "en-US"],
    UZS: ["soʻm", "Uzbekistani Som", "en-US"],
    KGS: ["с", "Kyrgyzstani Som", "en-US"],
    TJS: ["SM", "Tajikistani Somoni", "en-US"],
    TMT: ["m", "Turkmenistani Manat", "en-US"],
    PGK: ["K", "Papua New Guinean Kina", "en-US"],
    FJD: ["FJ$", "Fijian Dollar", "en-US"],
    XPF: ["₣", "CFP Franc", "en-US"],
    DOP: ["RD$", "Dominican Peso", "en-US"],
    CRC: ["₡", "Costa Rican Colon", "en-US"],
    GTQ: ["Q", "Guatemalan Quetzal", "en-US"],
    HNL: ["L", "Honduran Lempira", "en-US"],
    NIO: ["C$", "Nicaraguan Cordoba", "en-US"],
    PAB: ["B/.", "Panamanian Balboa", "en-US"],
    BOB: ["Bs.", "Bolivian Boliviano", "en-US"],
    PYG: ["₲", "Paraguayan Guarani", "en-US"],
    TTD: ["TT$", "Trinidad & Tobago Dollar", "en-US"],
    BBD: ["Bds$", "Barbadian Dollar", "en-US"],
    BSD: ["B$", "Bahamian Dollar", "en-US"],
    CUP: ["₱", "Cuban Peso", "en-US"],
    HTG: ["G", "Haitian Gourde", "en-US"],
    GYD: ["G$", "Guyanese Dollar", "en-US"],
    SRD: ["Sr$", "Surinamese Dollar", "en-US"],
    AWG: ["ƒ", "Aruban Florin", "en-US"],
    ANG: ["ƒ", "Netherlands Antillean Guilder", "en-US"],
    KYD: ["CI$", "Cayman Islands Dollar", "en-US"],
    BMD: ["BD$", "Bermudian Dollar", "en-US"]
  };

  var ALIASES = {
    rupee: "INR", rupees: "INR", rs: "INR", indian: "INR", india: "INR",
    dollar: "USD", dollars: "USD", usdollar: "USD", americandollar: "USD",
    euros: "EUR", pound: "GBP", pounds: "GBP", sterling: "GBP", poundsterling: "GBP",
    yen: "JPY", yuan: "CNY", rmb: "CNY", renminbi: "CNY",
    dirham: "AED", dirhams: "AED", riyal: "SAR", riyals: "SAR", saudiriyal: "SAR",
    franc: "CHF", rand: "ZAR", naira: "NGN", taka: "BDT", baht: "THB",
    ringgit: "MYR", peso: "MXN", real: "BRL", won: "KRW", lira: "TRY",
    ruble: "RUB", rouble: "RUB", shekel: "ILS", bitcoin: "BTC"
  };

  var INDEX = null;

  function norm(s) {
    return String(s == null ? "" : s).toLowerCase().replace(/[^a-z0-9\u0080-\uffff]/g, "");
  }

  function buildIndex() {
    INDEX = {};
    var code;
    for (code in CURRENCIES) {
      INDEX[norm(code)] = code;
      INDEX[norm(CURRENCIES[code][1])] = code;
      INDEX[norm(CURRENCIES[code][0])] = INDEX[norm(CURRENCIES[code][0])] || code;
    }
    for (var a in ALIASES) INDEX[norm(a)] = ALIASES[a];
  }

  function resolve(input) {
    if (!INDEX) buildIndex();
    var raw = String(input == null ? "" : input).trim();
    var code = INDEX[norm(raw)];
    if (!code) {
      var words = raw.split(/[\s(),\-_\/]+/);
      for (var i = 0; i < words.length && !code; i++) code = INDEX[norm(words[i])];
    }
    if (code) {
      var c = CURRENCIES[code];
      return { code: code, symbol: c[0], name: c[1], locale: (code === "INR" ? "en-IN" : "en-US"), known: true };
    }
    return { code: raw.toUpperCase(), symbol: raw.toUpperCase(), name: raw, locale: "en-US", known: false };
  }

  var state = {
    baseCurrency: "INR",
    currency: "INR",
    selector: ".currency",
    minWidth: "100px",
    ratesUrl: null,
    cacheHours: 6,
    rates: null,
    ratesUpdated: null,
    ratesPromise: null,
    observer: null,
    warned: {}
  };


  function parseAmount(v) {
    if (typeof v === "number") return v;
    var n = parseFloat(String(v).replace(/[^0-9.\-]/g, ""));
    return isNaN(n) ? 0 : n;
  }

  function formatAmount(num, locale) {
    try {
      return new Intl.NumberFormat(locale, {
        minimumFractionDigits: 2,
        maximumFractionDigits: 2
      }).format(num);
    } catch (e) {
      return num.toFixed(2);
    }
  }

  function warnOnce(key, msg) {
    if (state.warned[key] || !global.console) return;
    state.warned[key] = true;
    console.warn("[CurrencyHandler] " + msg);
  }

  function shouldSkip(el) {
    if (!el.closest) return false;
    if (el.closest(".dataTables_sizing, .dt-scroll-sizing")) return true;
    if (el.closest(
      ".dataTables_scrollBody tfoot, .dataTables_scrollBody thead, " +
      ".dt-scroll-body tfoot, .dt-scroll-body thead"
    )) return true;
    if (el.querySelector(".dataTables_sizing, .dt-scroll-sizing")) return true;
    return false;
  }


  function cacheKey() { return "currencyHandlerRates:" + resolve(state.baseCurrency).code; }

  function readCache() {
    try {
      var c = JSON.parse(global.localStorage.getItem(cacheKey()) || "null");
      if (c && c.rates && c.exp > Date.now()) return c;
    } catch (e) {}
    return null;
  }

  function writeCache(rates, updated) {
    try {
      global.localStorage.setItem(cacheKey(), JSON.stringify({
        rates: rates,
        updated: updated,
        exp: Date.now() + state.cacheHours * 3600 * 1000
      }));
    } catch (e) {}
  }

  function ensureRates() {
    if (state.rates) return Promise.resolve(state.rates);
    if (state.ratesPromise) return state.ratesPromise;

    var cached = readCache();
    if (cached) {
      state.rates = cached.rates;
      state.ratesUpdated = cached.updated;
      return Promise.resolve(state.rates);
    }

    var base = resolve(state.baseCurrency).code;
    var url = state.ratesUrl || ("https://open.er-api.com/v6/latest/" + base);

    state.ratesPromise = global.fetch(url)
      .then(function (r) {
        if (!r.ok) throw new Error("HTTP " + r.status);
        return r.json();
      })
      .then(function (d) {
        if (d.result && d.result !== "success") throw new Error("API error: " + d.result);
        var rates = d.rates || d.conversion_rates;
        if (!rates) throw new Error("No 'rates' in response");
        state.rates = rates;
        state.ratesUpdated = d.time_last_update_utc || new Date().toUTCString();
        writeCache(rates, state.ratesUpdated);
        return rates;
      })
      .catch(function (e) {
        state.ratesPromise = null;
        if (global.console) console.error("[CurrencyHandler] Could not load exchange rates:", e);
        return null;
      });

    return state.ratesPromise;
  }

  function needsRates() {
    var base = resolve(state.baseCurrency).code;
    if (resolve(state.currency).code !== base) return true;
    return !!document.querySelector(state.selector + "[data-currency]");
  }


  function renderEl(el) {
    if (shouldSkip(el)) return;

    if (!el.hasAttribute("data-amount")) {
      el.setAttribute("data-amount", parseAmount(el.textContent));
    }
    var raw = parseAmount(el.getAttribute("data-amount"));

    var base = resolve(state.baseCurrency);
    var want = resolve(el.getAttribute("data-currency") || state.currency);
    var info = want;
    var amount = raw;

    if (want.code !== base.code) {
      var rate = state.rates && state.rates[want.code];
      if (rate) {
        amount = raw * rate;
      } else {
        info = base;
        warnOnce("norate-" + want.code,
          "No exchange rate for '" + want.code + "'. Showing " + base.code + " instead.");
      }
    }

    var display = global.getComputedStyle ? global.getComputedStyle(el).display : "block";
    if (display === "inline") {
      el.style.display = "inline-block";
      if (!el.style.minWidth) el.style.minWidth = state.minWidth;
    }

    el.textContent = "";

    var wrap = document.createElement("span");
    wrap.className = "currency-wrap";
    wrap.style.cssText =
      "display:flex;justify-content:space-between;align-items:baseline;gap:8px;width:100%;";

    var sym = document.createElement("span");
    sym.className = "currency-symbol";
    sym.textContent = info.symbol;
    sym.title = info.name + (info.known ? " (" + info.code + ")" : "");

    var amt = document.createElement("span");
    amt.className = "currency-amount";
    amt.style.textAlign = "right";
    amt.textContent = formatAmount(amount, info.locale);

    wrap.appendChild(sym);
    wrap.appendChild(amt);
    el.appendChild(wrap);
    el.setAttribute("data-currency-rendered", info.code);

    if (!info.known) {
      warnOnce("unknown-" + info.name,
        "Unknown currency '" + info.name + "'. Showing it as-is. Add it to CURRENCIES if needed.");
    }
  }

  function renderAll() {
    var list = document.querySelectorAll(state.selector);
    for (var i = 0; i < list.length; i++) renderEl(list[i]);
    return list.length;
  }

  function watchDom() {
    if (state.observer || !global.MutationObserver || !document.body) return;
    state.observer = new MutationObserver(function (mutations) {
      for (var m = 0; m < mutations.length; m++) {
        var added = mutations[m].addedNodes;
        for (var k = 0; k < added.length; k++) {
          var n = added[k];
          if (n.nodeType !== 1) continue;
          if (n.matches && n.matches(state.selector) &&
              !n.hasAttribute("data-currency-rendered")) renderEl(n);
          if (n.querySelectorAll) {
            var kids = n.querySelectorAll(state.selector);
            for (var j = 0; j < kids.length; j++) {
              if (!kids[j].hasAttribute("data-currency-rendered")) renderEl(kids[j]);
            }
          }
        }
      }
    });
    state.observer.observe(document.body, { childList: true, subtree: true });
  }


  var CurrencyHandler = {
   
    init: function (opts) {
      opts = opts || {};
      if (opts.baseCurrency) state.baseCurrency = opts.baseCurrency;
      state.currency = opts.currency || state.baseCurrency;
      if (opts.selector) state.selector = opts.selector;
      if (opts.minWidth) state.minWidth = opts.minWidth;
      if (opts.ratesUrl) state.ratesUrl = opts.ratesUrl;
      if (opts.cacheHours) state.cacheHours = opts.cacheHours;
      if (opts.rates) { state.rates = opts.rates; state.ratesUpdated = "manual"; }

      var start = function () {
        var go = function () {
          renderAll();
          if (opts.watch !== false) watchDom();
        };
        if (needsRates()) ensureRates().then(go); else go();
      };
      if (document.readyState === "loading") {
        document.addEventListener("DOMContentLoaded", start);
      } else {
        start();
      }
    },

    setCurrency: function (nameOrCode) {
      state.currency = nameOrCode;
      return ensureRates().then(function () { renderAll(); });
    },

    bindSelect: function (selector) {
      var sel = document.querySelector(selector);
      if (!sel) return;
      sel.value = resolve(state.currency).code;
      sel.addEventListener("change", function () {
        CurrencyHandler.setCurrency(sel.value);
      });
    },

    refreshRates: function () {
      try { global.localStorage.removeItem(cacheKey()); } catch (e) {}
      state.rates = null;
      state.ratesPromise = null;
      return ensureRates().then(function () { renderAll(); });
    },

    getCurrency: function () { return resolve(state.currency); },
    getBaseCurrency: function () { return resolve(state.baseCurrency); },
    getSymbol: function (nameOrCode) { return resolve(nameOrCode || state.currency).symbol; },
    getRate: function (nameOrCode) {
      var c = resolve(nameOrCode || state.currency).code;
      if (c === resolve(state.baseCurrency).code) return 1;
      return state.rates ? state.rates[c] : undefined;
    },
    getRatesUpdated: function () { return state.ratesUpdated; },

    format: function (amount, nameOrCode) {
      var target = resolve(nameOrCode || state.currency);
      var rate = CurrencyHandler.getRate(target.code);
      var value = parseAmount(amount) * (rate || 1);
      var shown = rate ? target : resolve(state.baseCurrency);
      return shown.symbol + " " + formatAmount(value, shown.locale);
    },

    list: function () { return CURRENCIES; },
    refresh: renderAll,

    getCurrencies: function () {
      var out = [];
      for (var code in CURRENCIES) {
        if (code === "BTC") continue;
        out.push({ code: code, name: CURRENCIES[code][1], symbol: CURRENCIES[code][0] });
      }
      out.sort(function (a, b) { return a.code < b.code ? -1 : 1; });
      return out;
    },

    getName: function (nameOrCode) { return resolve(nameOrCode).name; },

    ready: function () { return ensureRates().then(function (r) { return !!r; }); },

    convert: function (amount, from, to) {
      var f = resolve(from).code, t = resolve(to).code, base = resolve(state.baseCurrency).code;
      var fr = (f === base) ? 1 : (state.rates && state.rates[f]);
      var tr = (t === base) ? 1 : (state.rates && state.rates[t]);
      if (!fr || !tr) return null;
      return parseAmount(amount) / fr * tr;
    },

    bindCurrencyInput: function (opts) {
      var sel = document.querySelector(opts.select);
      var inp = document.querySelector(opts.input);
      if (!sel || !inp) { if (global.console) console.error("[CurrencyHandler] select/input not found"); return; }

      var $ = global.jQuery;
      var prev = sel.value;
      var base = resolve(state.baseCurrency);
      function el(s) { return s ? document.querySelector(s) : null; }

      function syncHidden() {
        var code = sel.value;
        var n = el(opts.hiddenName), b = el(opts.hiddenBase), r = el(opts.hiddenRate);
        if (n) n.value = resolve(code).name;
        var inBase = CurrencyHandler.convert(inp.value, code, base.code);
        var rate = CurrencyHandler.convert(1, code, base.code);
        if (b) b.value = (inBase === null || inp.value === "") ? "" : inBase.toFixed(2);
        if (r) r.value = rate === null ? "" : rate.toFixed(6);
      }

      function handleChange() {
        var from = prev, to = sel.value;
        if (from === to) return;
        ensureRates().then(function () {
          var out = null;
          if (String(inp.value).trim() === "") {
            out = "";
          } else {
            var c = CurrencyHandler.convert(inp.value, from, to);
            if (c === null) {
              alert("Exchange rate not available for " + to + ". Please try again.");
              sel.value = from;
              if ($ && $.fn && $.fn.selectpicker) $(sel).selectpicker("refresh");
              return;
            }
            out = c.toFixed(2);
          }
          inp.value = out;
          prev = to;
          if (opts.updatePage) CurrencyHandler.setCurrency(to);
          syncHidden();
          if (typeof opts.onChange === "function") {
            opts.onChange({ from: from, to: to, value: out });
          } else if (typeof global.itemcal === "function") {
            global.itemcal();
          }
        });
      }

      if ($) { $(sel).on("change", handleChange); }
      else { sel.addEventListener("change", handleChange); }
      inp.addEventListener("input", syncHidden);

      ensureRates().then(syncHidden);
    }
  };

  global.CurrencyHandler = CurrencyHandler;
  global.CurrencyHelper  = CurrencyHandler;
})(window);