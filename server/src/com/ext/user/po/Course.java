package com.ext.user.po;

import com.ext.util.DatabaseUtils;

public class Course {

	private int id;
	private String name;
	private String teacher;
	private String note;
	private int schoolId;
	// 设置自增长
		public Course() {
			this.id = DatabaseUtils.INVALID_INT_ID;		
			this.schoolId = DatabaseUtils.INVALID_INT_ID;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTeacher() {
			return teacher;
		}
		public void setTeacher(String teacher) {
			this.teacher = teacher;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public int getSchoolId() {
			return schoolId;
		}
		public void setSchoolId(int schoolId) {
			this.schoolId = schoolId;
		}
		@Override
		public String toString() {
			return "Course [id=" + id + ", name=" + name + ", teacher="
					+ teacher + ", note=" + note + ", schoolId=" + schoolId
					+ "]";
		}
		
}
