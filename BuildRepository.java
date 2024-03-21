public interface BuildRepository extends JpaRepository<Build, Long> {
    List<Build> findByChampionId(Long championId);
}
