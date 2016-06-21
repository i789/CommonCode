
CREATE TABLE Province(
	[ProvinceId] [int] NOT NULL,
	[ProvinceCode] [varchar](6) NOT NULL,
	[ProvinceName] [nvarchar](50) NOT NULL
)
CREATE TABLE [City](
	[CityId] [int] NOT NULL,
	[CityCode] [varchar](6) NOT NULL,
	[CityName] [nvarchar](50) NOT NULL,
	[ProvinceCode] [varchar](6) NOT NULL
) ON [PRIMARY]
CREATE TABLE [Area](
	[AreaId] [int] NOT NULL,
	[AreaCode] [varchar](6) NOT NULL,
	[AreaName] [nvarchar](50) NOT NULL,
	[CityCode] [varchar](6) NOT NULL
)


