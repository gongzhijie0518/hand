package hbi.core.db.table


import com.hand.hap.liquibase.MigrationHelper

def mhi = MigrationHelper.getInstance()

databaseChangeLog(logicalFilePath: "hbi/core/db/2016-06-01-init-migration.groovy") {


    changeSet(id: "20190326-zhijie.gong-1", author: "zhijie.gong") {

        if (mhi.isDbType('oracle')) {
            createSequence(sequenceName: 'FND_FLEX_STRUCTURES_S', startValue: "10001")
        }
        createTable(tableName: "FND_FLEX_STRUCTURES") {
            column(name: 'APPLICATION_ID', type: 'BIGINT', autoIncrement: "true", startWith: "10001") {
                constraints(nullable: false, primaryKey: "true", primaryKeyName: "FND_FLEX_STRUCTURES_PK")
            }
            column(name: 'ID_FLEX_CODE', type: 'VARCHAR(100)') {
                constraints(nullable: false)
            }
            column(name: "ENABLED_FLAG", type: 'VARCHAR(100)', defaultValue: "Y") {
                constraints(nullable: false)
            }

            column(name: "ID_FLEX_NAME", type: 'VARCHAR(240)')
            column(name: "object_version_number", type: "BIGINT", defaultValue: "-1")
            column(name: "request_id", type: "BIGINT", defaultValue: "-1")
            column(name: "program_id", type: "BIGINT", defaultValue: "-1")
            column(name: "created_by", type: "BIGINT", defaultValue: "-1")
            column(name: "creation_date", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "last_updated_by", type: "BIGINT", defaultValue: "-1")
            column(name: "last_update_date", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "last_update_login", type: "BIGINT", defaultValue: "-1")

        }
    }

    changeSet(id: '20190327-zhijie.gong-1', author: 'zhijie.gong') {
        if (mhi.isDbType('oracle')) {
            createSequence(sequenceName: 'CIN_CIRC_REPORTING_ORGS_S', startValue: "10001")
        }
        createTable(remarks: '统信报送机构表', tableName: 'CIN_CIRC_REPORTING_ORGS') {
            column(name: 'REP_ORG_ID', type: 'BIGINT', autoIncrement: "true", startWith: "10001", remarks: "报送机构ID") {
                constraints(nullable: false, primaryKey: "true", primaryKeyName: "CIN_CIRC_REPORTING_ORGS_PK")
            }
            column(name: 'REP_ORG_CODE', type: 'VARCHAR(50)', remarks: '报送机构代码')
            column(name: 'REP_ORG_NAME', type: 'VARCHAR(100)', remarks: '报送机构名称')
            column(name: 'REP_ORG_DESC', type: 'VARCHAR(50)', remarks: '报送机构说明')
            column(name: 'REP_ORG_TYPE', type: 'VARCHAR(50)', remarks: '机构类型')
            column(name: 'ENABLED_FLAG', type: 'VARCHAR(1)', remarks: '启用标志')
            column(name: 'START_DATE_ACTIVE', type: 'date')
            column(name: 'END_DATE_ACTIVE', type: 'date')
            column(name: "object_version_number", type: "BIGINT", defaultValue: "-1")
            column(name: "request_id", type: "BIGINT", defaultValue: "-1")
            column(name: "program_id", type: "BIGINT", defaultValue: "-1")
            column(name: "created_by", type: "BIGINT", defaultValue: "-1")
            column(name: "creation_date", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "last_updated_by", type: "BIGINT", defaultValue: "-1")
            column(name: "last_update_date", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "last_update_login", type: "BIGINT", defaultValue: "-1")
            column(name: 'ATTRIBUTE_CATEGORY', type: 'VARCHAR(30)')
            column(name: 'ATTRIBUTE1', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE2', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE3', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE4', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE5', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE6', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE7', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE8', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE9', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE10', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE11', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE12', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE13', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE14', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE15', type: 'VARCHAR(150)')
            column(name: 'FT_FLEX_CODE', type: 'VARCHAR(20)', remarks: '分摊应用编码')
            column(name: 'TX_FLEX_CODE', type: 'VARCHAR(20)', remarks: '统信引用编码')
        }
    }
    changeSet(id: '20190327-zhijie.gong-2', author: 'zhijie.gong') {

        createTable(remarks: '统信报送机构表多语言表', tableName: 'CIN_CIRC_REPORTING_ORGS_TL') {
            column(name: 'REP_ORG_ID', type: 'BIGINT', remarks: "报送机构ID") {
                constraints(nullable: false, primaryKey: "true")
            }
            column(name: 'LANG',type: 'VARCHAR(10)',remarks: '语言'){
                constraints(nullable: "false",primaryKey: "true")
            }
            column(name: 'REP_ORG_NAME', type: 'VARCHAR(100)', remarks: '报送机构名称')
            column(name: 'REP_ORG_DESC', type: 'VARCHAR(50)', remarks: '报送机构说明')
            column(name: "object_version_number", type: "BIGINT", defaultValue: "-1")
            column(name: "request_id", type: "BIGINT", defaultValue: "-1")
            column(name: "program_id", type: "BIGINT", defaultValue: "-1")
            column(name: "created_by", type: "BIGINT", defaultValue: "-1")
            column(name: "creation_date", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "last_updated_by", type: "BIGINT", defaultValue: "-1")
            column(name: "last_update_date", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "last_update_login", type: "BIGINT", defaultValue: "-1")
            column(name: 'ATTRIBUTE_CATEGORY', type: 'VARCHAR(30)')
            column(name: 'ATTRIBUTE1', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE2', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE3', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE4', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE5', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE6', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE7', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE8', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE9', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE10', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE11', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE12', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE13', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE14', type: 'VARCHAR(150)')
            column(name: 'ATTRIBUTE15', type: 'VARCHAR(150)')
        }
    }
}