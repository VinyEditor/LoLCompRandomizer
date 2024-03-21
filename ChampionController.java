@RestController
@RequestMapping("/api/champions")
public class ChampionController {
    @Autowired
    private ChampionService championService;

    @PostMapping
    public ResponseEntity<Champion> createChampion(@RequestBody Champion champion) {
        return new ResponseEntity<>(championService.createChampion(champion), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Champion>> getAllChampions() {
        return new ResponseEntity<>(championService.getAllChampions(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Champion> getChampionById(@PathVariable Long id) {
        Optional<Champion> champion = championService.getChampionById(id);
        if (champion.isPresent()) {
            return new ResponseEntity<>(champion.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{championId}/builds")
    public ResponseEntity<Build> createBuild(@PathVariable Long championId, @RequestBody Build build) {
        build.setChampionId(championId);
        return new ResponseEntity<>(championService.createBuild(build), HttpStatus.CREATED);
    }

    @GetMapping("/{championId}/builds")
    public ResponseEntity<List<Build>> getAllBuildsByChampionId(@PathVariable Long championId) {
        List<Build> builds = buildRepository.findByChampionId(championId);
        return new ResponseEntity<>(builds, HttpStatus.OK);
    }

    @GetMapping("/{championId}/builds/random")
    public ResponseEntity<Build> getRandomBuildForChampion(@PathVariable Long championId) {
        Build build = championService.getRandomBuildForChampion(championId);
        return new ResponseEntity<>(build, HttpStatus.OK);
    }
}
