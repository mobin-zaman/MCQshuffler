-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2019 at 01:53 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mcq`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `teacherId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `name`, `teacherId`) VALUES
(1, 'chata course', 1),
(2, 'matha course', 2),
(3, 'filmology', 4),
(4, 'amder deshta', 1),
(8, 'sadat', 1),
(9, 'Sadat', 4),
(16, 'sdfsd', 1),
(17, 'sdfsd', 1),
(19, 'sdfesd', 1),
(20, 'sdfsd', 1),
(21, 'sdf', 1),
(22, 'dfsdfsd', 1),
(23, 'sfsdf', 1),
(24, 'sdfsdf', 1),
(25, 'sd', 1),
(26, 'fsd', 1),
(27, 'Computer Organization and Architecture', 1),
(28, 'r', 4),
(29, 'r', 4),
(31, 'fdsfs', 4),
(32, 'Sadat', 4),
(34, 'sdfsd', 4),
(38, 'sdfsd', 4),
(41, 'sdfsd', 4),
(42, 'sdffsd', 4),
(44, 'Sadat Keno Chakor', 4),
(45, 'Sasdfa', 4),
(46, 'SDFSD', 4),
(47, 'sdat', 4),
(48, 'my brand new Course for testing', 4),
(49, 'brandNewCourse', 4);

-- --------------------------------------------------------

--
-- Table structure for table `course_student`
--

CREATE TABLE `course_student` (
  `id` int(100) NOT NULL,
  `courseId` int(100) NOT NULL,
  `studentId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_student`
--

INSERT INTO `course_student` (`id`, `courseId`, `studentId`) VALUES
(1, 3, 1),
(3, 27, 1),
(4, 2, 1),
(5, 1, 2),
(6, 1, 1),
(9, 49, 13);

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `id` int(100) NOT NULL,
  `courseId` int(100) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `isPublished` tinyint(1) NOT NULL DEFAULT '0',
  `Duration` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`id`, `courseId`, `Description`, `isPublished`, `Duration`) VALUES
(14, 1, 'mid term', 0, 10),
(15, 1, 'Sadat', 0, 34),
(16, 1, 'Sadat', 0, 34),
(17, 1, 'Sadat', 0, 34),
(18, 1, 'assdfasdf', 0, 343),
(19, 1, 'assdfasdf', 0, 343),
(20, 1, 'dfs', 0, 3),
(21, 1, 'kutta', 0, 20),
(22, 1, 'kutta', 0, 101),
(23, 1, 'kutta', 0, 101),
(24, 1, 'kutta', 0, 101),
(25, 1, 'kutta', 0, 101),
(26, 1, 'kutta', 0, 101),
(27, 1, 'kutta', 0, 101),
(28, 1, 'kutta', 0, 101),
(29, 1, 'kutta', 0, 101),
(30, 1, 'kutta', 0, 10),
(31, 1, 'ada', 0, 34),
(34, 3, 'fdg', 1, 45),
(35, 3, 'sdf3', 0, 3),
(38, 3, 'shundor name', 1, 65),
(39, 3, 'Sadats Exam', 1, 90),
(40, 49, 'brandNewExam', 1, 5),
(42, 49, 'one', 1, 61);

-- --------------------------------------------------------

--
-- Table structure for table `exam_question`
--

CREATE TABLE `exam_question` (
  `id` int(100) NOT NULL,
  `examId` int(100) NOT NULL,
  `questionId` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exam_question`
--

INSERT INTO `exam_question` (`id`, `examId`, `questionId`) VALUES
(7, 14, 1),
(8, 14, 4),
(9, 15, 4),
(10, 15, 2),
(11, 15, 16),
(12, 15, 18),
(13, 15, 3),
(14, 15, 1),
(15, 16, 4),
(16, 16, 2),
(17, 16, 1),
(18, 16, 18),
(19, 16, 3),
(20, 16, 16),
(21, 17, 4),
(22, 17, 1),
(23, 17, 16),
(24, 17, 3),
(25, 17, 2),
(26, 17, 18),
(27, 18, 2),
(28, 18, 18),
(29, 18, 16),
(30, 18, 4),
(31, 18, 1),
(32, 18, 3),
(33, 19, 18),
(34, 19, 4),
(35, 19, 2),
(36, 19, 1),
(37, 19, 16),
(38, 19, 3),
(39, 20, 18),
(40, 20, 4),
(41, 20, 1),
(42, 21, 18),
(43, 21, 16),
(44, 21, 3),
(45, 21, 1),
(46, 21, 4),
(47, 21, 2),
(48, 22, 2),
(49, 22, 18),
(50, 22, 3),
(51, 22, 16),
(52, 22, 1),
(53, 22, 4),
(54, 23, 1),
(55, 23, 2),
(56, 23, 16),
(57, 23, 4),
(58, 23, 18),
(59, 23, 3),
(60, 24, 1),
(61, 24, 16),
(62, 24, 3),
(63, 24, 4),
(64, 24, 18),
(65, 24, 2),
(66, 25, 18),
(67, 25, 16),
(68, 25, 3),
(69, 25, 1),
(70, 25, 2),
(71, 25, 4),
(72, 26, 3),
(73, 26, 2),
(74, 26, 16),
(75, 26, 18),
(76, 26, 4),
(77, 26, 1),
(78, 27, 3),
(79, 27, 18),
(80, 27, 2),
(81, 27, 1),
(82, 27, 4),
(83, 27, 16),
(84, 28, 16),
(85, 28, 3),
(86, 28, 1),
(87, 28, 18),
(88, 28, 2),
(89, 28, 4),
(90, 29, 18),
(91, 29, 2),
(92, 29, 1),
(93, 29, 16),
(94, 29, 4),
(95, 29, 3),
(96, 30, 4),
(97, 30, 2),
(98, 30, 16),
(99, 30, 18),
(100, 30, 1),
(101, 30, 3),
(102, 31, 4),
(103, 31, 18),
(104, 31, 2),
(107, 34, 12),
(108, 34, 14),
(109, 34, 7),
(110, 34, 11),
(111, 34, 13),
(112, 34, 10),
(113, 34, 6),
(114, 34, 5),
(115, 34, 9),
(116, 34, 15),
(117, 34, 8),
(118, 35, 7),
(119, 35, 11),
(120, 35, 10),
(143, 38, 6),
(144, 38, 14),
(145, 38, 7),
(146, 38, 5),
(147, 38, 8),
(148, 38, 12),
(149, 38, 13),
(150, 38, 15),
(151, 38, 10),
(152, 38, 11),
(153, 38, 9),
(154, 39, 5),
(155, 39, 7),
(156, 39, 12),
(157, 39, 14),
(158, 39, 11),
(159, 40, 25),
(161, 42, 25);

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `id` int(10) NOT NULL,
  `examId` int(10) NOT NULL,
  `studentId` int(10) NOT NULL,
  `marks` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`id`, `examId`, `studentId`, `marks`) VALUES
(18, 31, 2, 20),
(19, 31, 6, 20),
(20, 42, 13, 0),
(21, 42, 13, 1);

-- --------------------------------------------------------

--
-- Table structure for table `question`
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
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `courseId`, `description`, `choiceOne`, `choiceTwo`, `choiceThree`, `choiceFour`, `correctChoice`) VALUES
(1, 1, 'this is question 1', 'answer 1', 'answer 2', 'answer 3', 'answer 4', 'answer 3'),
(2, 1, 'this is question 2', 'choice 1', 'choice 2', 'choice 3', '`choice 4', 'choice 1'),
(3, 1, 'this is question3', 'c1', 'c2', 'c3', 'c4', 'c2'),
(4, 1, 'this is question4', 'c5', 'c6', 'c7 ', 'c8', 'c8'),
(5, 3, 'who is the director of lost in translation?', 'mark jaka', 'tim burton', 'sofia cappola', 'sophie turner', 'sofia cappola'),
(6, 3, 'on which of the the year pakistan film society was made?', '1953', '1963', '1981', '1950', '1963'),
(7, 3, '\'empire of the sun\' is a film by-', 'steven spielberg', 'christopher nolan', 'david fincher', 'paul thomas anderson', 'steven spielberg'),
(8, 3, 'netflix \'sacred games\' original reflected the life of which hooligan of india?', 'haji mastan', 'karim lala', 'dawood ibrahim', 'ganesh gaitonde', 'ganesh gaitonde'),
(9, 3, 'who is playing the central cast of \'joker\'(2019)?', 'steve blum', 'heath ledger', 'jared leto', 'joaquin phoenix', 'joaquin phoenix'),
(10, 3, '76th golden globe held in which year?', '2018', '2013', '2018', '2005', '2018'),
(11, 3, 'the film followed by the novel\'unbearable lightness of being\' was based on which historical circumstance?', 'the labor movement', 'scandinavian revival', 'czechoslovak period', 'suffragists\' movement by women', 'czechoslovak period'),
(12, 3, 'tarkovsky\'s first feature film was-', 'the killers', 'ivan\'s childhood', 'andrei rublev', 'solaris', 'ivan\'s childhood'),
(13, 3, 'what is the full name of charlie chaplin?', 'alfred charlie joseph chaplin', 'charlie frank chaplin', 'charles spencer chaplin', 'charles frank chaplin', 'charles spencer chaplin'),
(14, 3, 'padatik was diected by noted parallel cinema director-', 'ritwik ghatak', 'tapan sinha', 'mrinal sen', 'shyan benegal', 'mrinal sen'),
(15, 3, '\'live from dhaka\' is a debut film by', 'srijit mukherjee', 'mostofa sarwar farooky', 'abdullah mohammad saad', 'tauquir ahmed', 'abdullah mohammad saad'),
(16, 1, 'amader guu', 'gu1', 'gu2', 'gu3', 'gu4', 'gu3'),
(18, 1, 'fafds', 'fsdffff', 'fdf', 'f', 'f', 'f'),
(21, 1, 'xxxx', 'ffsd', 'dfrdsfds', 'f', 'sdfs', 'sdfs'),
(22, 46, 'sdf', '3', '3', '3', '3', '3'),
(24, 48, 'EASRD', 'WE', 'W', 'W', 'WW', 'W'),
(25, 49, 'Hello', 'h11111', 'h2', 'h3', 'h4', 'h2');

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `id` int(100) NOT NULL,
  `courseId` int(100) NOT NULL,
  `studentId` int(100) NOT NULL,
  `isAccepted` int(10) NOT NULL DEFAULT '0',
  `isRejected` int(10) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`id`, `courseId`, `studentId`, `isAccepted`, `isRejected`) VALUES
(22, 4, 1, 0, 0),
(23, 9, 1, 0, 0),
(24, 8, 1, 0, 0),
(25, 16, 1, 0, 0),
(26, 21, 2, 0, 0),
(27, 3, 3, 1, 0),
(28, 3, 6, 1, 0),
(29, 3, 7, 0, 1),
(30, 49, 8, 0, 1),
(31, 49, 9, 1, 0),
(32, 49, 10, 1, 0),
(33, 48, 10, 0, 0),
(34, 49, 11, 1, 0),
(35, 49, 12, 1, 0),
(36, 49, 13, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `password`) VALUES
(1, 'g', 'g'),
(2, 'e', 'e'),
(3, 'honeySingh', 'hs'),
(4, 'honeySingh', 'kutta'),
(5, 'honeySingh', '34'),
(6, 'google', 'g'),
(7, 'kutta', '44'),
(8, 'mobin', 'mobnkutta'),
(9, 'newUser', 'new'),
(10, 'ss', 'ss'),
(11, 'hell', 'hellyah'),
(12, 'eee', 'eeeeee'),
(13, 'tt', 't');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `id` int(100) NOT NULL,
  `name` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`id`, `name`, `password`) VALUES
(1, 'z', 'z'),
(2, 'menmen', 'menmen'),
(4, 'r', 'r');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `teacher_id` (`teacherId`);

--
-- Indexes for table `course_student`
--
ALTER TABLE `course_student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_course_course` (`courseId`),
  ADD KEY `fk_course_student` (`studentId`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_course_exam` (`courseId`);

--
-- Indexes for table `exam_question`
--
ALTER TABLE `exam_question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_exam_question` (`examId`),
  ADD KEY `fk_exam_question_question_id` (`questionId`);

--
-- Indexes for table `marks`
--
ALTER TABLE `marks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_exam_marks` (`examId`),
  ADD KEY `fk_marks_student` (`studentId`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_course_question` (`courseId`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_request_course` (`courseId`),
  ADD KEY `fk_request_student` (`studentId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `course_student`
--
ALTER TABLE `course_student`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `exam_question`
--
ALTER TABLE `exam_question`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=162;

--
-- AUTO_INCREMENT for table `marks`
--
ALTER TABLE `marks`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `fk_course_teacher` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `course_student`
--
ALTER TABLE `course_student`
  ADD CONSTRAINT `fk_course_course` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`),
  ADD CONSTRAINT `fk_course_student` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`);

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `fk_course_exam` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `exam_question`
--
ALTER TABLE `exam_question`
  ADD CONSTRAINT `fk_exam_question` FOREIGN KEY (`examId`) REFERENCES `exam` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_exam_question_question_id` FOREIGN KEY (`questionId`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `fk_exam_marks` FOREIGN KEY (`examId`) REFERENCES `exam` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_marks_student` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `fk_course_question` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`);

--
-- Constraints for table `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `fk_request_course` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`),
  ADD CONSTRAINT `fk_request_student` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
