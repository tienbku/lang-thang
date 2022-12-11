package com.langthang.event.listener;


import com.langthang.model.entity.Post;
import com.langthang.utils.MyStringUtils;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.time.Instant;


@Slf4j
@Component
public class PostEntityListener {

    @PreUpdate
    @PrePersist
    private void onAnyPostUpdate(Post post) {
        String slug = MyStringUtils.createSlug(post.getTitle()) + "-" + RandomStringUtils.randomAlphanumeric(5);
        String encodedContent = MyStringUtils.escapeHtml(post.getContent());
        post.setContent(encodedContent);

        if (post.isPublished() && post.getPublishedDate() == null) post.setPublishedDate(Instant.now());
        if (post.getSlug() == null) post.setSlug(slug);
    }
}