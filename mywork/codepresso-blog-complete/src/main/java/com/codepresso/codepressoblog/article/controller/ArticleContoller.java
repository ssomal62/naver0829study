

@PostMapping
public ResponseEntity<ArticleResponseDto> createArticle(@RequestBody ArticleRequestDto articleRequestDto) {
        //로직 생략
        Article article = articleRequestDto.toEntity();
        articleService.deleteArticle(article);
        return ResponseEntity.ok().body(articleResponseDto);
        }