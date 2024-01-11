public Article createArticle(LoginUser loginUser, ArticleDto articleDto) {
        //복잡한 로직이 존재한다고 가정...
        Tags tags = tagService.findTagsByTagColor(articleDto.getTagColor());
        List<History> history = loginUser.findFormerHistories(tags);
        Article article = new Article(articleDto.getId(), articleDto.getName(), articleDto.getContent(), tags, history);
        return articleRepository.save(article);
        }