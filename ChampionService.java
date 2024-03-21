@Service
public class ChampionService {
    @Autowired
    private ChampionRepository championRepository;
    @Autowired
    private BuildRepository buildRepository;

    public Champion createChampion(Champion champion) {
        return championRepository.save(champion);
    }

    public List<Champion> getAllChampions() {
        return championRepository.findAll();
    }

    public Optional<Champion> getChampionById(Long id) {
        return championRepository.findById(id);
    }

    public Build createBuild(Build build) {
        return buildRepository.save(build);
    }

    public List<Build> getAllBuilds() {
        return buildRepository.findAll();
    }

    public Optional<Build> getBuildById(Long id) {
        return buildRepository.findById(id);
    }

    public Build getRandomBuildForChampion(Long championId) {
        List<Build> builds = buildRepository.findByChampionId(championId);
        if (builds.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No builds found for this champion.");
        }
        return builds.get(new Random().nextInt(builds.size()));
    }
}
