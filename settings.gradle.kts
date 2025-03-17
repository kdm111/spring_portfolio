rootProject.name = "portfolio"
include("src:test:domain")
findProject(":src:test:domain")?.name = "domain"
