-- begin SAMPLER_ORDER
alter table SAMPLER_ORDER add constraint FK_SAMPLER_ORDER_CUSTOMER_ID foreign key (CUSTOMER_ID) references SAMPLER_CUSTOMER(ID)^
create index IDX_SAMPLER_ORDER_CUSTOMER on SAMPLER_ORDER (CUSTOMER_ID)^
-- end SAMPLER_ORDER
-- begin SAMPLER_TASK
alter table SAMPLER_TASK add constraint FK_SAMPLER_TASK_ASSIGNEE_ID foreign key (ASSIGNEE_ID) references SAMPLER_CUSTOMER(ID)^
alter table SAMPLER_TASK add constraint FK_SAMPLER_TASK_PARENT_TASK_ID foreign key (PARENT_TASK_ID) references SAMPLER_TASK(ID)^
create index IDX_SAMPLER_TASK_PARENT_TASK on SAMPLER_TASK (PARENT_TASK_ID)^
create index IDX_SAMPLER_TASK_ASSIGNEE on SAMPLER_TASK (ASSIGNEE_ID)^
-- end SAMPLER_TASK

-- begin SAMPLER_INVOICE_ITEM
alter table SAMPLER_INVOICE_ITEM add constraint FK_SAMPLER_INVOICE_ITEM_PRODUCT_ID foreign key (PRODUCT_ID) references SAMPLER_PRODUCT(ID)^
alter table SAMPLER_INVOICE_ITEM add constraint FK_SAMPLER_INVOICE_ITEM_ORDER_ID foreign key (ORDER_ID) references SAMPLER_ORDER(ID)^
create index IDX_SAMPLER_INVOICE_ITEM_ORDER on SAMPLER_INVOICE_ITEM (ORDER_ID)^
create index IDX_SAMPLER_INVOICE_ITEM_PRODUCT on SAMPLER_INVOICE_ITEM (PRODUCT_ID)^
-- end SAMPLER_INVOICE_ITEM
-- begin SAMPLER_SEGMENT
alter table SAMPLER_SEGMENT add constraint FK_SAMPLER_SEGMENT_TASK_SPAN_ID foreign key (TASK_SPAN_ID) references SAMPLER_TASK_SPAN(ID)^
create index IDX_SAMPLER_SEGMENT_TASK_SPAN on SAMPLER_SEGMENT (TASK_SPAN_ID)^
-- end SAMPLER_SEGMENT
