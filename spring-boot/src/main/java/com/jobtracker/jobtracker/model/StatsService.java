package com.jobtracker.jobtracker.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobtracker.jobtracker.repository.DailyLogRepository;
import com.jobtracker.jobtracker.repository.JobApplicationRepository;
import com.jobtracker.jobtracker.repository.TaskRepository;

@Service
public class StatsService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private DailyLogRepository dailyLogRepository;

    public Map<String, Object> getStats(int userId) {
        Map<String, Object> stats = new HashMap<>();

        Map<String, Long> jobStats = new HashMap<>();
        for (Object[] row : jobApplicationRepository.countByStatus(userId)) {
            jobStats.put((String) row[0], (Long) row[1]);
        }
        stats.put("jobApplications", jobStats);

        Map<String, Long> taskStats = new HashMap<>();
        for (Object[] row : taskRepository.countByStatus(userId)) {
            taskStats.put((String) row[0], (Long) row[1]);
        }
        stats.put("tasks", taskStats);

        Double hours = dailyLogRepository.sumHoursSpent(userId);
        stats.put("totalHoursSpent", hours != null ? hours : 0.0);

        Long topics = dailyLogRepository.countDistinctTopics(userId);
        stats.put("distinctTopicsCovered", topics != null ? topics : 0);

        return stats;
    }
}