const apiUrl = 'https://ddragon.leagueoflegends.com/cdn/14.6.1/data/en_US/champion.json';
const championSelectEl = document.getElementById('champion-select');
const buildEl = document.getElementById('build');

// Fetch champion data from Data Dragon API
async function fetchChampionData() {
  const response = await fetch(apiUrl);
  const data = await response.json();
  return data.data;
}

// Generate random champion and build
async function generateBuild() {
  const champions = await fetchChampionData();
  const championIds = Object.keys(champions);
  const randomChampionId = championIds[Math.floor(Math.random() * championIds.length)];
  const champion = champions[randomChampionId];
  const items = champion.stats.startingItems;
  const build = items.map(itemId => champions[itemId].name).join(', ');
  championSelectEl.textContent = champion.name;
  buildEl.textContent = build;
}

// Initialize page
generateBuild();
