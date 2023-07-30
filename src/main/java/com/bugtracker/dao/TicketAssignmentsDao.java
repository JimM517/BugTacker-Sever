package com.bugtracker.dao;

import com.bugtracker.model.TicketAssignments;

import java.util.List;

public interface TicketAssignmentsDao {


    List<TicketAssignments> listAllCurrentAssignedTickets();

    TicketAssignments findByTicketId(int tickedId);

    List<TicketAssignments> findByUserId(int userId);

    TicketAssignments createAssignment(TicketAssignments newAssignment);

    TicketAssignments updateAssignment(TicketAssignments modifiedAssignment);




}
