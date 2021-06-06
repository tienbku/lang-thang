package com.langthang.services;

import com.langthang.dto.NotificationDTO;
import com.langthang.model.Account;
import com.langthang.model.Post;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INotificationServices {

    void createNotification(Account sourceAcc, String targetAccEmail, Post destPost, NotificationDTO.TYPE type);

    void createNotification(Account sourceAcc, Account destAcc, Post destPost, NotificationDTO.TYPE type);

    void sendNotificationToFollower(String sourceAccEmail, int destPostId);

    List<NotificationDTO> getNotifications(String accEmail, Pageable pageable);

    List<NotificationDTO> getUnseenNotifications(String accEmail);

    void maskAsSeen(int notificationId, String accEmail);
}
