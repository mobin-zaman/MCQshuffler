-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- হোষ্ট: localhost:3306
-- তৈরী করতে ব্যবহৃত সময়: এপ্রি 11, 2019 at 05:24 AM
-- সার্ভার সংস্করন: 5.7.25-0ubuntu0.18.04.2
-- পিএইছপির সংস্করন: 7.2.15-0ubuntu0.18.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- ডাটাবেইজ: `mcq`
--

-- --------------------------------------------------------

--
-- টেবলের জন্য টেবলের গঠন `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `teacherId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- টেবলের জন্য তথ্য স্তুপ করছি `course`
--

INSERT INTO `course` (`id`, `name`, `teacherId`) VALUES
(1, 'chata course', 1),
(2, 'matha course', 2);

-- --------------------------------------------------------

--
-- টেবলের জন্য টেবলের গঠন `course_student`
--

CREATE TABLE `course_student` (
  `id` int(100) NOT NULL,
  `courseId` int(100) NOT NULL,
  `studentId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- টেবলের জন্য টেবলের গঠন `exam`
--

CREATE TABLE `exam` (
  `id` int(100) NOT NULL,
  `courseId` int(100) NOT NULL,
  `Description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- টেবলের জন্য তথ্য স্তুপ করছি `exam`
--

INSERT INTO `exam` (`id`, `courseId`, `Description`) VALUES
(1, 1, 'first exam ever'),
(2, 1, 'first exam ever'),
(3, 1, 'test exam'),
(4, 1, 'test exam'),
(5, 1, 'test exam'),
(6, 1, 'final test exam'),
(7, 1, 'final test exam'),
(8, 1, 'final test exam'),
(9, 1, 'final test exam'),
(10, 1, 'final test exam'),
(11, 1, 'final test exam'),
(12, 1, 'final test exam'),
(13, 1, 'final2 test exam');

-- --------------------------------------------------------

--
-- টেবলের জন্য টেবলের গঠন `exam_question`
--

CREATE TABLE `exam_question` (
  `id` int(100) NOT NULL,
  `examId` int(100) NOT NULL,
  `questionId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- টেবলের জন্য তথ্য স্তুপ করছি `exam_question`
--

INSERT INTO `exam_question` (`id`, `examId`, `questionId`) VALUES
(1, 12, 1),
(2, 12, 3),
(3, 12, 2),
(4, 13, 3),
(5, 13, 1),
(6, 13, 2);

-- --------------------------------------------------------

--
-- টেবলের জন্য টেবলের গঠন `question`
--

CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `description` varchar(200) NOT NULL,
  `choiceOne` varchar(200) NOT NULL,
  `choiceTwo` varchar(200) NOT NULL,
  `choiceThree` varchar(200) NOT NULL,
  `choiceFour` varchar(200) NOT NULL,
  `correctChoice` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- টেবলের জন্য তথ্য স্তুপ করছি `question`
--

INSERT INTO `question` (`id`, `courseId`, `description`, `choiceOne`, `choiceTwo`, `choiceThree`, `choiceFour`, `correctChoice`) VALUES
(1, 1, 'this is question 1', 'answer 1', 'answer 2', 'answer 3', 'answer 4', 'answer 3'),
(2, 1, 'this is question 2', 'choice 1', 'choice 2', 'choice 3', '`choice 4', 'choice 1'),
(3, 1, 'this is question3', 'c1', 'c2', 'c3', 'c4', 'c2'),
(4, 1, 'this is question4', 'c5', 'c6', 'c7 ', 'c8', 'c8');

-- --------------------------------------------------------

--
-- টেবলের জন্য টেবলের গঠন `request`
--

CREATE TABLE `request` (
  `id` int(100) NOT NULL,
  `courseId` int(100) NOT NULL,
  `studentId` int(100) NOT NULL,
  `isAccepted` int(10) NOT NULL,
  `isRequested` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- টেবলের জন্য টেবলের গঠন `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- টেবলের জন্য তথ্য স্তুপ করছি `student`
--

INSERT INTO `student` (`id`, `name`, `password`) VALUES
(1, 'gadha student', 'gadha student'),
(2, 'goru chagol', 'goru chagol');

-- --------------------------------------------------------

--
-- টেবলের জন্য টেবলের গঠন `teacher`
--

CREATE TABLE `teacher` (
  `id` int(100) NOT NULL,
  `name` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- টেবলের জন্য তথ্য স্তুপ করছি `teacher`
--

INSERT INTO `teacher` (`id`, `name`, `password`) VALUES
(1, 'mohaim', 'mohaim'),
(2, 'menmen', 'menmen');

--
-- স্তুপকৃত টেবলের ইনডেক্স
--

--
-- টেবিলের ইনডেক্সসমুহ `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `teacher_id` (`teacherId`);

--
-- টেবিলের ইনডেক্সসমুহ `course_student`
--
ALTER TABLE `course_student`
  ADD PRIMARY KEY (`id`);

--
-- টেবিলের ইনডেক্সসমুহ `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_course_exam` (`courseId`);

--
-- টেবিলের ইনডেক্সসমুহ `exam_question`
--
ALTER TABLE `exam_question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_exam_question` (`examId`),
  ADD KEY `fk_exam_question_question_id` (`questionId`);

--
-- টেবিলের ইনডেক্সসমুহ `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_course_question` (`courseId`);

--
-- টেবিলের ইনডেক্সসমুহ `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_request_course` (`courseId`),
  ADD KEY `fk_request_student` (`studentId`);

--
-- টেবিলের ইনডেক্সসমুহ `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- টেবিলের ইনডেক্সসমুহ `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- স্তুপকৃত টেবলের জন্য স্বয়ক্রীয় বর্দ্ধিত মান (AUTO_INCREMENT)
--

--
-- টেবলের জন্য স্বয়ক্রীয় বর্দ্ধিত মান (AUTO_INCREMENT) `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- টেবলের জন্য স্বয়ক্রীয় বর্দ্ধিত মান (AUTO_INCREMENT) `course_student`
--
ALTER TABLE `course_student`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT;
--
-- টেবলের জন্য স্বয়ক্রীয় বর্দ্ধিত মান (AUTO_INCREMENT) `exam`
--
ALTER TABLE `exam`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- টেবলের জন্য স্বয়ক্রীয় বর্দ্ধিত মান (AUTO_INCREMENT) `exam_question`
--
ALTER TABLE `exam_question`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- টেবলের জন্য স্বয়ক্রীয় বর্দ্ধিত মান (AUTO_INCREMENT) `question`
--
ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- টেবলের জন্য স্বয়ক্রীয় বর্দ্ধিত মান (AUTO_INCREMENT) `request`
--
ALTER TABLE `request`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT;
--
-- টেবলের জন্য স্বয়ক্রীয় বর্দ্ধিত মান (AUTO_INCREMENT) `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- টেবলের জন্য স্বয়ক্রীয় বর্দ্ধিত মান (AUTO_INCREMENT) `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- স্তুপকৃত টেবলের সীমবদ্ধতা
--

--
-- টেবলের সীমবদ্ধতা `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `fk_course_teacher` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`);

--
-- টেবলের সীমবদ্ধতা `course_student`
--
ALTER TABLE `course_student`
  ADD CONSTRAINT `fk_course_course` FOREIGN KEY (`id`) REFERENCES `course` (`id`),
  ADD CONSTRAINT `fk_course_student` FOREIGN KEY (`id`) REFERENCES `student` (`id`);

--
-- টেবলের সীমবদ্ধতা `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `fk_course_exam` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`);

--
-- টেবলের সীমবদ্ধতা `exam_question`
--
ALTER TABLE `exam_question`
  ADD CONSTRAINT `fk_exam_question` FOREIGN KEY (`examId`) REFERENCES `exam` (`id`),
  ADD CONSTRAINT `fk_exam_question_question_id` FOREIGN KEY (`questionId`) REFERENCES `question` (`id`);

--
-- টেবলের সীমবদ্ধতা `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `fk_course_question` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`);

--
-- টেবলের সীমবদ্ধতা `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `fk_request_course` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`),
  ADD CONSTRAINT `fk_request_student` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
